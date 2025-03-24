package agin.llc1.llc1.decorator;

public class BaseDiscount implements Discount {
    @Override
    public double applyDiscount(double price) {
        return price;
    }
}
