package agin.llc1.llc1.decorator;

public class WeekendDiscountDecorator extends DiscountDecorator {
    public WeekendDiscountDecorator(Discount decoratedDiscount) {
        super(decoratedDiscount);
    }

    @Override
    public double applyDiscount(double price) {
        return super.applyDiscount(price) * 0.95;
    }
}
