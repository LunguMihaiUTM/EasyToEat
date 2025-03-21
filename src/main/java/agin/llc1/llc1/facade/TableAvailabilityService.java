package agin.llc1.llc1.facade;

import agin.llc1.llc1.entity.Table;
import agin.llc1.llc1.repository.TableRepository;
import agin.llc1.llc1.service.TableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TableAvailabilityService {
    private final TableRepository tableRepository;

    public Boolean isTableAvailable(Long tableId) {
        Optional<Table> table =  tableRepository.findById(tableId);
        if(table.isPresent()) {
            return table.get().getIsFree();
        }
        throw new RuntimeException("Table not found");
    }
}
