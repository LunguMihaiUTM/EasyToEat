package agin.llc1.llc1.dto;

import agin.llc1.llc1.service.MenuComponent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO implements MenuComponent {
    private Long id;
    private String dishName;
    private Double price;

    @Override
    public void showDetails() {
        System.out.println(dishName + " - " + price + " MDL");
    }
}
