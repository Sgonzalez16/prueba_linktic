package com.linktic.prueba_linktic.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProtectionDto {

    private Long codeProtection;
    private String nameProtection;
    private BigDecimal valueBonus;
}
