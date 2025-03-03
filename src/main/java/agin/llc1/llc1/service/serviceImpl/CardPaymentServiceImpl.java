package agin.llc1.llc1.service.serviceImpl;

import agin.llc1.llc1.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardPaymentServiceImpl implements PaymentService {

    @Override
    public String createPayment(){
        return "Card payment";
    }
}
