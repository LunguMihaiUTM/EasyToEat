package agin.llc1.llc1.observer;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TableAvailabilityNotifier {

    private final Map<Long, List<TableObserver>> observers = new HashMap<>();

    public void subscribe(Long locationId, TableObserver observer) {
        observers.computeIfAbsent(locationId, k -> new ArrayList<>()).add(observer);
    }

    public void unsubscribe(Long locationId, TableObserver observer) {
        observers.getOrDefault(locationId, new ArrayList<>()).remove(observer);
    }

    public List<String> notifyObservers(Long locationId, Long tableId) {
        List<String> messages = new ArrayList<>();
        List<TableObserver> locationObservers = observers.getOrDefault(locationId, Collections.emptyList());

        for (TableObserver observer : locationObservers) {
            messages.add(observer.notify(tableId));
        }

        return messages;
    }
}
