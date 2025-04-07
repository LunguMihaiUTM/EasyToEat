package agin.llc1.llc1.Iterator;

import agin.llc1.llc1.entity.Table;
import agin.llc1.llc1.repository.TableRepository;
import lombok.AllArgsConstructor;

import java.util.Iterator;
import java.util.List;

@AllArgsConstructor
public class CancelReservationIterator implements Iterator<Table> {

    private final List<Long> tableIds;
    private int currentIndex = 0;
    private final TableRepository tableRepository;

    public CancelReservationIterator(List<Long> tableIds, TableRepository tableRepository) {
        this.tableIds = tableIds;
        this.tableRepository = tableRepository;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < tableIds.size();
    }

    @Override
    public Table next() {
        Long tableId = tableIds.get(currentIndex++);
        return tableRepository.findById(tableId).orElse(null);
    }

    public void cancelReservation(Table table) {
        if (table != null && !table.getIsFree()) {
            table.setIsFree(true);
            tableRepository.save(table);
        }
    }
}