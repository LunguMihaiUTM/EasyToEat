package agin.llc1.llc1.controller;

import agin.llc1.llc1.factory.PaymentFactory;
import agin.llc1.llc1.proxy.PaymentProcessingServiceImpl;
import agin.llc1.llc1.proxy.PaymentServiceProxy;
import agin.llc1.llc1.service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("payment")
public class PaymentController {

    private final PaymentFactory paymentFactory;
    private final PaymentProcessingServiceImpl paymentServiceProxy;


    @GetMapping("{type}")
    public String processPayment(@PathVariable String type) {
        PaymentService paymentService = paymentFactory.createPaymentService(type);
        return paymentService.createPayment();
    }


    //Proxy
    @PostMapping("/process")
    public String processPaymentProxy(@RequestParam double amount, @RequestParam String paymentMethod) {
        return paymentServiceProxy.processPayment(amount, paymentMethod);
    }
}
