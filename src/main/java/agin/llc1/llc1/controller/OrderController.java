package agin.llc1.llc1.controller;

import agin.llc1.llc1.service.serviceImpl.OrderServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderServiceImpl orderService;

    @PostMapping("/place")
    public String placeOrder(@RequestParam String orderDetails,
                             @RequestParam String platformType,
                             @RequestParam String orderType) {
        return orderService.placeOrder(orderDetails, platformType, orderType);
    }
}