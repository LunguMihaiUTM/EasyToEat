package agin.llc1.llc1.facade;

import org.springframework.stereotype.Service;

@Service
public class ReservationConfirmationService {

    public void sendReservationConfirmation(String email) {
        System.out.println("Sending reservation confirmation to: " + email);
    }
}
