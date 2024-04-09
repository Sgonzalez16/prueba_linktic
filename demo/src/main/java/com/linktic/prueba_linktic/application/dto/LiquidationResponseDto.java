package com.linktic.prueba_linktic.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class LiquidationResponseDto {

    private int identificationType;
    private String identificationNumber;
    private BigDecimal insuredValue;
    private List<ProtectionDto> liquidation;
    private BigDecimal totalvalue;
}
