package com.linktic.prueba_linktic.application.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class LiquidationRequestDto {

    @NotNull
    private int identificationType;
    @NotNull
    private String identificationNumber;
    @NotNull
    private BigDecimal insuredValue;
    private LocalDate dateBirth;
}
