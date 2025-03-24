package agin.llc1.llc1.bridge;

import org.springframework.stereotype.Component;

@Component
public class ReservationOrder implements OrderType {
    @Override
    public String placeOrder(String orderDetails) {
        return "Rezervarea mesei a fost realizată pentru: " + orderDetails;
    }
}
