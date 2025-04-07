package agin.llc1.llc1.strategy;

public class CityDeliveryStrategy implements DeliveryTimeStrategy {
    @Override
    public int calculateTime() {
        return 30;
    }
}

