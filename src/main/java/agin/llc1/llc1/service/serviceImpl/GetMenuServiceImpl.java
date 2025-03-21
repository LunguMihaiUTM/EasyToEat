package agin.llc1.llc1.service.serviceImpl;

import agin.llc1.llc1.dto.ItemDTO;
import agin.llc1.llc1.dto.MenuDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GetMenuServiceImpl {

    ItemDTO pizza = new ItemDTO(1L, "Pizza Margherita", 35.0);
    ItemDTO cola = new ItemDTO(2L, "Coca-Cola", 8.0);
    ItemDTO burger = new ItemDTO(3L, "Cheeseburger", 25.0);

    public MenuDTO getMenu() {
        MenuDTO dailyMenu = new MenuDTO(10L, "Meniul Zilei", new ArrayList<>());
        dailyMenu.addItem(pizza);
        dailyMenu.addItem(cola);

        MenuDTO mainMenu = new MenuDTO(20L, "Meniu Restaurant", new ArrayList<>());
        mainMenu.addItem(dailyMenu);
        mainMenu.addItem(burger);

        mainMenu.showDetails();
        return mainMenu;
    }

}
