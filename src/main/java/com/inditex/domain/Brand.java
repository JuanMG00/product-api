package com.inditex.domain;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    @NotNull
    private String name;
}
