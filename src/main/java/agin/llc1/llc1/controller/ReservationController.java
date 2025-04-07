package agin.llc1.llc1.controller;

import agin.llc1.llc1.command.CancelReservationCommand;
import agin.llc1.llc1.command.CommandExecutor;
import agin.llc1.llc1.command.ReserveTableCommand;
import agin.llc1.llc1.service.serviceImpl.ReservationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("reservation")
public class ReservationController {

    private final ReservationServiceImpl reservationService;
    private final CommandExecutor commandExecutor;


    @PostMapping("/reserve/{tableId}")
    public String reserveTable(@PathVariable Long tableId) {
        ReserveTableCommand command = new ReserveTableCommand(reservationService, tableId);
        return commandExecutor.executeCommand(command);
    }

    @PostMapping("/cancel/{tableId}")
    public String cancelReservation(@PathVariable Long tableId) {
        CancelReservationCommand command = new CancelReservationCommand(reservationService, tableId);
        return commandExecutor.executeCommand(command);
    }
}
