package agin.llc1.llc1.controller;

import agin.llc1.llc1.factory.PaymentFactory;
import agin.llc1.llc1.service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("payment")
public class PaymentController {

    private final PaymentFactory paymentFactory;

    @GetMapping("{type}")
    public String processPayment(@PathVariable String type) {
        PaymentService paymentService = paymentFactory.createPaymentService(type);
        return paymentService.createPayment();
    }
}
