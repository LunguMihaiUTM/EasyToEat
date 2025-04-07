package agin.llc1.llc1.memento;

import java.util.*;

public class TableCaretaker {
    private final Map<Long, List<TableMemento>> tableHistory = new HashMap<>();

    public void addMemento(Long tableId, TableMemento memento) {
        tableHistory.computeIfAbsent(tableId, k -> new ArrayList<>()).add(memento);
    }

    public List<TableMemento> getHistory(Long tableId) {
        return tableHistory.getOrDefault(tableId, Collections.emptyList());
    }
}
