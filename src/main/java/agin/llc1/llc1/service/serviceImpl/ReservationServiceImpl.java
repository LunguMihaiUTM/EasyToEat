package agin.llc1.llc1.service.serviceImpl;

import agin.llc1.llc1.entity.Table;
import agin.llc1.llc1.repository.TableRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReservationServiceImpl {

    private final TableRepository tableRepository;

    public String reserveTable(Long tableId) {
        Table table = tableRepository.findById(tableId).orElseThrow(() -> new EntityNotFoundException("Table not found"));
        if(table.getIsFree()){
            table.setIsFree(false);
            tableRepository.save(table);
            return "Table successfully reserved";
        }else{
            return "Table is already reserved";
        }
    }

    public String cancelReservation(Long tableId) {
        Table table = tableRepository.findById(tableId).orElseThrow(() -> new EntityNotFoundException("Table not found"));
        table.setIsFree(true);
        tableRepository.save(table);
        return "Reservation successfully cancelled";
    }
}
