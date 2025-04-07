package agin.llc1.llc1.memento;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TableMemento {
    private final Boolean isFree;
    private final Long locationId;
}
