package com.inditex.domain;

import com.inditex.domain.enums.Currency;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

class PricesTest {

    @Test
    void testPricesEntity() {
        // Create a sample Prices object
        Brand brand = Brand.builder().id(1).name("Example Brand").build();
        PriceList priceList = PriceList.builder().id(1).build();
        Product product = Product.builder().id(1).name("Example Product").build();

        LocalDateTime startDate = LocalDateTime.now();
        LocalDateTime endDate = startDate.plusDays(7);

        Prices prices = Prices.builder()
                .id(1)
                .brand(brand)
                .startDate(startDate)
                .endDate(endDate)
                .priceList(priceList)
                .product(product)
                .price(BigDecimal.valueOf(9.99))
                .priority(1)
                .curr(Currency.EUR)
                .build();

        // Verify that the entity fields are set correctly
        Assertions.assertEquals(1, prices.getId());
        Assertions.assertEquals(brand, prices.getBrand());
        Assertions.assertEquals(startDate, prices.getStartDate());
        Assertions.assertEquals(endDate, prices.getEndDate());
        Assertions.assertEquals(priceList, prices.getPriceList());
        Assertions.assertEquals(product, prices.getProduct());
        Assertions.assertEquals(BigDecimal.valueOf(9.99), prices.getPrice());
        Assertions.assertEquals(1, prices.getPriority());
        Assertions.assertEquals(Currency.EUR, prices.getCurr());
    }
}
