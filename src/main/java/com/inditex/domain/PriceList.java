package com.inditex.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
public class PriceList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    // since not specified properties have not been added

}
