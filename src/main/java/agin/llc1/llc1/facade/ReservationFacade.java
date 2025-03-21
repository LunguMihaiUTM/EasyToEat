package agin.llc1.llc1.facade;

import agin.llc1.llc1.entity.Table;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationFacade {

    private final TableAvailabilityService tableAvailabilityService;

    private final TableReservationService tableReservationService;

    private final ReservationConfirmationService reservationConfirmationService;

    public String reserveTableForUser(Long tableId, String userEmail) {

        boolean isAvailable = tableAvailabilityService.isTableAvailable(tableId);

        if (isAvailable) {
            tableReservationService.reserveTable(tableId);
            reservationConfirmationService.sendReservationConfirmation(userEmail);
            return "Table was successfully reserved";
        } else {
            return "Table is not available";
        }
    }
}
