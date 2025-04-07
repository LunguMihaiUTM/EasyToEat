package agin.llc1.llc1.controller;

import agin.llc1.llc1.entity.Table;
import agin.llc1.llc1.memento.TableMemento;
import agin.llc1.llc1.observer.TableAvailabilityNotifier;
import agin.llc1.llc1.observer.UserObserver;
import agin.llc1.llc1.service.TableService;
import agin.llc1.llc1.service.serviceImpl.TableServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/table")
public class TableController {

    private final TableServiceImpl tableService;

    //Iterator
    @PostMapping("/cancel-reservations")
    public String cancelReservations(@RequestBody List<Long> tableIds) {
        return tableService.cancelReservations(tableIds);
    }


    //Memento
    @PostMapping("update/{id}/status")
    public String updateStatus(@PathVariable Long id, @RequestParam boolean free) {
        return tableService.updateTableStatus(id, free);
    }

    @GetMapping("/{id}/history")
    public List<TableMemento> getHistory(@PathVariable Long id) {
        return tableService.getTableHistory(id);
    }

    //Observer
    private final TableAvailabilityNotifier notifier;

    @PostMapping("/{tableId}/set-free")
    public ResponseEntity<String> setTableFree(@PathVariable Long tableId) {
        boolean becameFree = tableService.setTableFree(tableId);

        if (becameFree) {
            Table table = tableService.getTableById(tableId);
            List<String> messages = notifier.notifyObservers(table.getLocationId(), tableId);
            return ResponseEntity.ok("Masa a fost eliberată și utilizatorii au fost notificați:\n" +
                    String.join("\n", messages));
        }

        return ResponseEntity.ok("Masa era deja disponibilă.");
    }

    @PostMapping("/subscribe")
    public ResponseEntity<String> subscribe(@RequestParam Long locationId, @RequestParam String email) {
        notifier.subscribe(locationId, new UserObserver(email));
        return ResponseEntity.ok("Utilizatorul " + email + " s-a abonat la notificări pentru locația " + locationId);
    }

}