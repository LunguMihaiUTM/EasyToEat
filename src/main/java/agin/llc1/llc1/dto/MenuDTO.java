package agin.llc1.llc1.dto;

import agin.llc1.llc1.service.MenuComponent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuDTO implements MenuComponent {
    private Long id;
    private String name;
    private List<MenuComponent> items = new ArrayList<>();

    public void addItem(MenuComponent item) {
        items.add(item);
    }

    @Override
    public void showDetails() {
        System.out.println("\n" + name + ":");
        for (MenuComponent item : items) {
            item.showDetails();
        }
    }
}
