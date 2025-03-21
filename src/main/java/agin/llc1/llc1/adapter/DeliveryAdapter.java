package agin.llc1.llc1.adapter;

import agin.llc1.llc1.service.DeliveryService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeliveryAdapter implements DeliveryService {
    private final ExternalCourierService externalCourier;

    @Override
    public String deliverOrder(Long orderId, String address) {
        externalCourier.sendPackage(orderId, address);
        return "Success";
    }
}

