package agin.llc1.llc1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    private Long id;
    private String address;
    @ManyToAny
    private Restaurant restaurantId;
}
