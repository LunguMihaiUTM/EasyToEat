package agin.llc1.llc1.entity;

import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    private Long id;
    private Table tableId;
    @OneToOne
    private Location locationId;
    private String bookingStatus;
    private LocalDateTime orderTime;
    private Integer nrPeople;
    private Double finalPrice;
    private String name;
    private String phoneNumber;
    private String items;
}
