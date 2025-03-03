package agin.llc1.llc1.controller;

import agin.llc1.llc1.factory.FastFoodRestaurantFactory;
import agin.llc1.llc1.factory.FineDiningRestaurantFactory;
import agin.llc1.llc1.factory.RestaurantFactory;
import agin.llc1.llc1.service.ItemsService;
import agin.llc1.llc1.service.TableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @PostMapping("/{type}")
    public ResponseEntity<?> bookRestaurant(@PathVariable String type){
        RestaurantFactory restaurantFactory = null;
        if(type.equals("fastFood")){
            restaurantFactory = new FastFoodRestaurantFactory();
        } else if (type.equals("fineDining")){
            restaurantFactory = new FineDiningRestaurantFactory();
        }
        ItemsService itemsService = restaurantFactory.createItemsService();
        itemsService.createItems();
        TableService tableService = restaurantFactory.createTableService();
        tableService.createTable();
        return ResponseEntity.ok().build();
    }

}
