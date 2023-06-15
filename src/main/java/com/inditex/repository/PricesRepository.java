package com.inditex.repository;

import com.inditex.domain.Prices;
import com.inditex.repository.projections.PriceProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Optional;

@RepositoryRestResource(path = "prices", excerptProjection = PriceProjection.class )
public interface PricesRepository extends JpaRepository<Prices, Integer> {
    @SuppressWarnings("unused")
    @RestResource(path = "applicable-price", rel = "applicable-price")
    @Query("SELECT p FROM Prices p " +
            "WHERE p.product.id = :productId " +
            "AND p.brand.id = :brandId " +
            "AND p.startDate <= :applicationDate " +
            "AND p.endDate >= :applicationDate " +
            "AND p.priority = (SELECT MAX(p2.priority) FROM Prices p2 " +
            "                  WHERE p2.product.id = :productId " +
            "                  AND p2.brand.id = :brandId " +
            "                  AND p2.startDate <= :applicationDate " +
            "                  AND p2.endDate >= :applicationDate)")
    Optional<Prices> findMatchingPrice(@Param("productId") Integer productId,
                                       @Param("brandId") Integer brandId,
                                       @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                                       @Param("applicationDate") LocalDateTime applicationDate);
}
