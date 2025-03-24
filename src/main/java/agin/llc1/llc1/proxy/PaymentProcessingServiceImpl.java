package agin.llc1.llc1.proxy;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentProcessingServiceImpl {

    private final PaymentServiceProxy paymentServiceProxy;

    public String processPayment(double amount, String paymentMethod) {
        return paymentServiceProxy.processPayment(amount, paymentMethod);
    }
}
