package agin.llc1.llc1.memento;
import agin.llc1.llc1.entity.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class TableOriginator {
    private Table table;

    public TableMemento saveStateToMemento() {
        return new TableMemento(table.getIsFree(), table.getLocationId());
    }

    public void restoreStateFromMemento(TableMemento memento) {
        table.setIsFree(memento.getIsFree());
        table.setLocationId(memento.getLocationId());
    }
}
