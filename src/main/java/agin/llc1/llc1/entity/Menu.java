package agin.llc1.llc1.entity;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    private Long id;
    @ManyToOne
    private Restaurant restaurantId;
}
