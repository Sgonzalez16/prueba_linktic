package com.linktic.prueba_linktic.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "primas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BonusModel {

    @Id
    @Column(name = "codigo")
    private int code;

    @Column(name = "edad_min")
    private Long minimumAge;

    @Column(name = "edad_max")
    private Long maximumAge;

    @Column(name = "porcentaje_prima")
    private BigDecimal percentageBonus;
}
