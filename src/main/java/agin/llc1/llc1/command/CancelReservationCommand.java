package agin.llc1.llc1.command;

import agin.llc1.llc1.service.serviceImpl.ReservationServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
public class CancelReservationCommand implements Command {

    private final ReservationServiceImpl reservationService;
    private final Long tableId;

    @Override
    public String execute() {
        return reservationService.cancelReservation(tableId);
    }
}
