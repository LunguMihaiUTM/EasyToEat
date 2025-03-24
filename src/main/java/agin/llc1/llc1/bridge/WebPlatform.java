package agin.llc1.llc1.bridge;

import org.springframework.stereotype.Component;

@Component
public class WebPlatform implements Platform {
    @Override
    public String placeOrderOnPlatform(String orderDetails, OrderType orderType) {
        return "Plasare comandă pe platforma Web: " + orderType.placeOrder(orderDetails);
    }
}
