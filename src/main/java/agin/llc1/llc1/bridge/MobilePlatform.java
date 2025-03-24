package agin.llc1.llc1.bridge;

import org.springframework.stereotype.Component;

@Component
public class MobilePlatform implements Platform {
    @Override
    public String placeOrderOnPlatform(String orderDetails, OrderType orderType) {
        return "Plasare comandă pe platforma Mobilă: " + orderType.placeOrder(orderDetails);
    }
}