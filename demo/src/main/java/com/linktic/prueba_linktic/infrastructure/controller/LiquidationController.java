package com.linktic.prueba_linktic.infrastructure.controller;

import com.linktic.prueba_linktic.application.dto.LiquidationRequestDto;
import com.linktic.prueba_linktic.application.dto.LiquidationResponseDto;
import com.linktic.prueba_linktic.application.service.ILiquidationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/liquidation")
@RequiredArgsConstructor
public class LiquidationController {

    private final ILiquidationService liquidationService;

    @PostMapping("/calculateLiquidation")
    public ResponseEntity<LiquidationResponseDto> calculateLiquidation(@RequestBody @Valid LiquidationRequestDto request) {
        try {
            LiquidationResponseDto response = liquidationService.calculateLiquidation(request);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
