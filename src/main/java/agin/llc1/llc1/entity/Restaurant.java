package agin.llc1.llc1.entity;

import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    private Long id;
    private String restaurantName;
    @OneToOne
    private Category categoryId;
}
