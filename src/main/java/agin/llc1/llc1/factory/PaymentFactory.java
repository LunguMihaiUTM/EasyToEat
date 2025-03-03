package agin.llc1.llc1.factory;

import agin.llc1.llc1.service.PaymentService;
import agin.llc1.llc1.service.serviceImpl.CardPaymentServiceImpl;
import agin.llc1.llc1.service.serviceImpl.CashPaymentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class PaymentFactory {
    public PaymentService createPaymentService(String type) {
        if(type == null || type.isEmpty()){
            return null;
        }
        if(type.equalsIgnoreCase("card")){
            return new CardPaymentServiceImpl();
        } else if(type.equalsIgnoreCase("cash")){
            return new CashPaymentServiceImpl();
        }
        return null;
    }
}
