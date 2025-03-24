package agin.llc1.llc1.decorator;

public class LoyaltyDiscountDecorator extends DiscountDecorator {
    public LoyaltyDiscountDecorator(Discount decoratedDiscount) {
        super(decoratedDiscount);
    }

    @Override
    public double applyDiscount(double price) {
        return super.applyDiscount(price) * 0.90;
    }
}
