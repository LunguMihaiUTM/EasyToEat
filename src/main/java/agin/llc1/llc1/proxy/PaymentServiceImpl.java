package agin.llc1.llc1.proxy;

import org.springframework.stereotype.Service;


//Simulare tip de plata externa
@Service
public class PaymentServiceImpl {
    public String processPayment(double amount, String paymentMethod) {
        return "Plata in suma de " + amount + " a fost procesatat cu succes prin metoda " + paymentMethod;
    }
}

