package agin.llc1.llc1.controller;

import agin.llc1.llc1.adapter.DeliveryAdapter;
import agin.llc1.llc1.adapter.ExternalCourierService;
import agin.llc1.llc1.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    ExternalCourierService externalCourier = new ExternalCourierService();
    DeliveryService deliveryService = new DeliveryAdapter(externalCourier);

    @PostMapping()
    public ResponseEntity<String> sendOrder(@RequestParam Long orderId, @RequestParam String address ) {
        return ResponseEntity.ok(deliveryService.deliverOrder(orderId,address));
    }


}
