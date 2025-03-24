package agin.llc1.llc1.bridge;

import org.springframework.stereotype.Component;

@Component
public class PreOrder implements OrderType {
    @Override
    public String placeOrder(String orderDetails) {
        return "Precomanda a fost plasată pentru: " + orderDetails;
    }
}


