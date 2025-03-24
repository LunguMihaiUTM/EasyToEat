package agin.llc1.llc1.bridge;

import org.springframework.stereotype.Component;

@Component
public class DeliveryOrder implements OrderType {
    @Override
    public String placeOrder(String orderDetails) {
        return "Comanda de livrare a fost plasată pentru: " + orderDetails;
    }
}
