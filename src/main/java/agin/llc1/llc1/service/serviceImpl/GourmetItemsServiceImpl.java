package agin.llc1.llc1.service.serviceImpl;

import agin.llc1.llc1.service.ItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GourmetItemsServiceImpl implements ItemsService {
    @Override
    public void createItems(){
        System.out.println("Gourmet Items");;
    }
}
