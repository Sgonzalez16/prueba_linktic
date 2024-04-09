package com.linktic.prueba_linktic.application.service;

import com.linktic.prueba_linktic.application.dto.LiquidationRequestDto;
import com.linktic.prueba_linktic.application.dto.LiquidationResponseDto;

public interface ILiquidationService {
    LiquidationResponseDto calculateLiquidation(LiquidationRequestDto request);
}
