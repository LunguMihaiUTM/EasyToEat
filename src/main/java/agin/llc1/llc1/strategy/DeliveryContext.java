package agin.llc1.llc1.strategy;
import lombok.Data;

@Data
public class DeliveryContext {
    private DeliveryTimeStrategy strategy;

    public int getEstimatedTime() {
        return strategy.calculateTime();
    }
}
