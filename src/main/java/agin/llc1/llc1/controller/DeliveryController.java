package agin.llc1.llc1.controller;

import agin.llc1.llc1.adapter.DeliveryAdapter;
import agin.llc1.llc1.adapter.ExternalCourierService;
import agin.llc1.llc1.service.DeliveryService;
import agin.llc1.llc1.strategy.CityDeliveryStrategy;
import agin.llc1.llc1.strategy.DeliveryContext;
import agin.llc1.llc1.strategy.OutskirtsDeliveryStrategy;
import agin.llc1.llc1.strategy.PickupStrategy;
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

    //Strategy
    @GetMapping("/estimate")
    public ResponseEntity<String> estimateDeliveryTime(@RequestParam String method) {
        DeliveryContext context = new DeliveryContext();

        switch (method.toLowerCase()) {
            case "city" -> context.setStrategy(new CityDeliveryStrategy());
            case "outskirts" -> context.setStrategy(new OutskirtsDeliveryStrategy());
            case "pickup" -> context.setStrategy(new PickupStrategy());
            default -> {
                return ResponseEntity.badRequest().body("Invalid delivery method.");
            }
        }

        int time = context.getEstimatedTime();
        return ResponseEntity.ok("Estimated delivery time: " + time + " minutes.");
    }



}
