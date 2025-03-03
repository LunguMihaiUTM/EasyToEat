package agin.llc1.llc1.factory;

import agin.llc1.llc1.service.ItemsService;
import agin.llc1.llc1.service.TableService;
import agin.llc1.llc1.service.serviceImpl.FastFoodItemsServiceImpl;
import agin.llc1.llc1.service.serviceImpl.FastFoodTableServiceImpl;
import agin.llc1.llc1.service.serviceImpl.GourmetItemsServiceImpl;
import agin.llc1.llc1.service.serviceImpl.ReservedTableServiceImpl;
import org.springframework.stereotype.Component;

@Component("fastFood")
public class FastFoodRestaurantFactory implements RestaurantFactory {

    @Override
    public ItemsService createItemsService() {
        return new FastFoodItemsServiceImpl();
    }

    @Override
    public TableService createTableService() {
        return new FastFoodTableServiceImpl();
    }
}
