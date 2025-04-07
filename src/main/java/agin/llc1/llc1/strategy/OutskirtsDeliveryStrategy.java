package agin.llc1.llc1.strategy;

public class OutskirtsDeliveryStrategy implements DeliveryTimeStrategy {
    @Override
    public int calculateTime() {
        return 60;
    }
}

