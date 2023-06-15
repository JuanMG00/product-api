package com.inditex.domain;

import com.inditex.domain.enums.Currency;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Prices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @JoinColumn
    @NotNull
    @ManyToOne
    private Brand brand;

    @Column
    @NotNull
    private LocalDateTime startDate;
    @Column
    @NotNull
    private LocalDateTime endDate;

    @JoinColumn(name = "price_list")
    @NotNull
    @ManyToOne
    private PriceList priceList;

    @JoinColumn
    @NotNull
    @ManyToOne
    private Product product;

    @Column
    @NotNull
    private BigDecimal price;

    @Column
    @NotNull
//  Desambiguador de aplicación de precios. Si dos tarifas coinciden en un rago de
//  fechas se aplica la de mayor prioridad (mayor valor numérico).
    private Integer priority;

    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    private Currency curr;
}
