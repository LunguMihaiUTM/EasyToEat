package agin.llc1.llc1.controller;

import agin.llc1.llc1.service.serviceImpl.DiscountService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/discount")
public class DiscountController {

    private final DiscountService discountService;

    @GetMapping("/calculate")
    public ResponseEntity<String> getDiscountedPrice(@RequestParam double price,
                                                     @RequestParam boolean isLoyalCustomer,
                                                     @RequestParam boolean isHoliday,
                                                     @RequestParam boolean isWeekend) {
        String response = discountService.calculateDiscountedPrice(price, isLoyalCustomer, isHoliday, isWeekend);
        return ResponseEntity.ok(response);
    }
}
