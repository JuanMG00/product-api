package com.inditex.controller;

import com.inditex.repository.projections.PriceProjection;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PriceProjectionTester(Integer brandId, Integer productId,
                                    Integer appliedTariff, LocalDateTime startDate,
                                    LocalDateTime endDate,
                                    BigDecimal price) implements PriceProjection {

    @Override
    public Integer getBrandId() {
        return brandId;
    }

    @Override
    public Integer getProductId() {
        return productId;
    }

    @Override
    public Integer getAppliedTariff() {
        return appliedTariff;
    }

    @Override
    public LocalDateTime getStartDate() {
        return startDate;
    }

    @Override
    public LocalDateTime getEndDate() {
        return endDate;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

}
