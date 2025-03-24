package agin.llc1.llc1.service.serviceImpl;

import agin.llc1.llc1.bridge.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl {

    private final WebPlatform webPlatform;
    private final MobilePlatform mobilePlatform;
    private final PreOrder preOrder;
    private final DeliveryOrder deliveryOrder;
    private final ReservationOrder reservationOrder;

    public String placeOrder(String orderDetails, String platformType, String orderType) {
        Platform platform;
        OrderType order;

        // Determinăm platforma
        if (platformType.equalsIgnoreCase("web")) {
            platform = webPlatform;
        } else {
            platform = mobilePlatform;
        }

        // Determinăm tipul de comandă
        if (orderType.equalsIgnoreCase("preorder")) {
            order = preOrder;
        } else if (orderType.equalsIgnoreCase("delivery")) {
            order = deliveryOrder;
        } else {
            order = reservationOrder;
        }

        return platform.placeOrderOnPlatform(orderDetails, order);
    }
}
