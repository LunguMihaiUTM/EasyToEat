package agin.llc1.llc1.factory;

import agin.llc1.llc1.service.ItemsService;
import agin.llc1.llc1.service.TableService;
import agin.llc1.llc1.service.serviceImpl.FastFoodItemsServiceImpl;
import agin.llc1.llc1.service.serviceImpl.FastFoodTableServiceImpl;
import agin.llc1.llc1.service.serviceImpl.GourmetItemsServiceImpl;
import agin.llc1.llc1.service.serviceImpl.ReservedTableServiceImpl;
import org.springframework.stereotype.Component;

@Component("fineDining")
public class FineDiningRestaurantFactory implements RestaurantFactory {

    @Override
    public ItemsService createItemsService() {
        return new GourmetItemsServiceImpl();
    }

    @Override
    public TableService createTableService() {
        return new ReservedTableServiceImpl();
    }
}
