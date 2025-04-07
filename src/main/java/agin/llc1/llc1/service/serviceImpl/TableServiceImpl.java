package agin.llc1.llc1.service.serviceImpl;

import agin.llc1.llc1.Iterator.CancelReservationIterator;
import agin.llc1.llc1.entity.Table;
import agin.llc1.llc1.memento.TableCaretaker;
import agin.llc1.llc1.memento.TableMemento;
import agin.llc1.llc1.memento.TableOriginator;
import agin.llc1.llc1.repository.TableRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TableServiceImpl {

    private final TableRepository tableRepository;


    //For Iterator
    public String cancelReservations(List<Long> tableIds) {
        CancelReservationIterator iterator = new CancelReservationIterator(tableIds, tableRepository);
        StringBuilder response = new StringBuilder();

        while (iterator.hasNext()) {
            Table table = iterator.next();
            iterator.cancelReservation(table);
            response.append("Reservation for table ID ")
                    .append(table.getId())
                    .append(" has been cancelled.\n");
        }

        return response.toString();
    }

    //For Memento
    private final TableCaretaker caretaker = new TableCaretaker();

    public String updateTableStatus(Long tableId, boolean newStatus) {
        Table table = tableRepository.findById(tableId)
                .orElseThrow(() -> new RuntimeException("Masa nu a fost găsită."));

        TableOriginator originator = new TableOriginator();
        originator.setTable(table);
        caretaker.addMemento(tableId, originator.saveStateToMemento());

        table.setIsFree(newStatus);
        tableRepository.save(table);

        return "Starea mesei a fost actualizată.";
    }

    public List<TableMemento> getTableHistory(Long tableId) {
        return caretaker.getHistory(tableId);
    }


    //Observer

    public boolean setTableFree(Long tableId) {
        Table table = tableRepository.findById(tableId)
                .orElseThrow(() -> new RuntimeException("Masa nu a fost găsită"));

        if (Boolean.TRUE.equals(table.getIsFree())) {
            return false; // deja liberă
        }

        table.setIsFree(true);
        tableRepository.save(table);
        return true;
    }

    public Table getTableById(Long tableId) {
        return tableRepository.findById(tableId)
                .orElseThrow(() -> new RuntimeException("Masa nu a fost găsită"));
    }
}