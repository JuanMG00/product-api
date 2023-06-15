package com.inditex.repository.projections;

import com.inditex.domain.Prices;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Projection(name = "priceProjection", types = {Prices.class})
public interface PriceProjection {

    @Value("#{target.brand.id}")
    Integer getBrandId();

    @Value("#{target.product.id}")
    Integer getProductId();

    @Value("#{target.priceList.id}")
    Integer getAppliedTariff();

    LocalDateTime getStartDate();

    LocalDateTime getEndDate();

    BigDecimal getPrice();
}
