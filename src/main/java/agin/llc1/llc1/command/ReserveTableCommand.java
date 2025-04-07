package agin.llc1.llc1.command;

import agin.llc1.llc1.service.serviceImpl.ReservationServiceImpl;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ReserveTableCommand implements Command {

    private final ReservationServiceImpl reservationService;
    private final Long tableId;

    @Override
    public String execute() {
        return reservationService.reserveTable(tableId);
    }
}
