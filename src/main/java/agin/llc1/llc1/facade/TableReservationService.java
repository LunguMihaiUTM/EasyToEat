package agin.llc1.llc1.facade;

import agin.llc1.llc1.entity.Table;
import agin.llc1.llc1.repository.TableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TableReservationService {


    private final TableRepository tableRepository;

    public void reserveTable(Long tableId) {
        Table table = tableRepository.findById(tableId).orElseThrow(() -> new RuntimeException("Table not found"));

        table.setIsFree(false);

        tableRepository.save(table);
    }
}