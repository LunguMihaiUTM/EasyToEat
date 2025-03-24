package agin.llc1.llc1.decorator;

public class HolidayDiscountDecorator extends DiscountDecorator {
    public HolidayDiscountDecorator(Discount decoratedDiscount) {
        super(decoratedDiscount);
    }

    @Override
    public double applyDiscount(double price) {
        return super.applyDiscount(price) * 0.85;
    }
}