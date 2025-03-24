package agin.llc1.llc1.proxy;

import org.springframework.stereotype.Service;

@Service
public class PaymentProxy implements PaymentServiceProxy {
    private final PaymentServiceImpl paymentService;
    private final boolean isUserAuthenticated;

    public PaymentProxy(PaymentServiceImpl paymentService) {
        this.paymentService = paymentService;
        this.isUserAuthenticated = checkUserAuthentication();
    }

    private boolean checkUserAuthentication() {
        String userToken = "validToken";
        System.out.println("Checking user authentication: " + userToken);
        return "validToken".equals(userToken);
    }

    @Override
    public String processPayment(double amount, String paymentMethod) {
        if (!isUserAuthenticated) {
            System.out.println("Error: User not authenticated. Please log in to proceed with the payment.");
            return "Error: User not authenticated. Please log in to proceed with the payment.";
        }
        System.out.println("Proxy: User authenticated, processing payment...");
        return paymentService.processPayment(amount, paymentMethod);
    }
}


