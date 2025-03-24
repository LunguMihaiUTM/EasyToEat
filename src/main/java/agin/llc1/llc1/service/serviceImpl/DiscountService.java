package agin.llc1.llc1.service.serviceImpl;

import agin.llc1.llc1.decorator.*;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {
    public String calculateDiscountedPrice(double price, boolean isLoyalCustomer, boolean isHoliday, boolean isWeekend) {
        Discount discount = new BaseDiscount();
        if (isLoyalCustomer) {
            discount = new LoyaltyDiscountDecorator(discount);
        }
        if (isHoliday) {
            discount = new HolidayDiscountDecorator(discount);
        }
        if (isWeekend) {
            discount = new WeekendDiscountDecorator(discount);
        }
        return "The final price is : " + discount.applyDiscount(price);
    }
}