package agin.llc1.llc1.service.serviceImpl;

import agin.llc1.llc1.service.TableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FastFoodTableServiceImpl implements TableService {
    @Override
    public void createTable() {
        System.out.println("No table required");;
    }
}
