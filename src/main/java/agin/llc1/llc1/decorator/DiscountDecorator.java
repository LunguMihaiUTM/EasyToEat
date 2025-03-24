package agin.llc1.llc1.decorator;

public abstract class DiscountDecorator implements Discount {
    protected Discount decoratedDiscount;

    public DiscountDecorator(Discount decoratedDiscount) {
        this.decoratedDiscount = decoratedDiscount;
    }

    @Override
    public double applyDiscount(double price) {
        return decoratedDiscount.applyDiscount(price);
    }
}
