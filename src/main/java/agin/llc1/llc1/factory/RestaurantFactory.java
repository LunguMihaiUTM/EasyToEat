package agin.llc1.llc1.factory;

import agin.llc1.llc1.service.ItemsService;
import agin.llc1.llc1.service.TableService;

public interface RestaurantFactory {
    ItemsService createItemsService();
    TableService createTableService();
}
