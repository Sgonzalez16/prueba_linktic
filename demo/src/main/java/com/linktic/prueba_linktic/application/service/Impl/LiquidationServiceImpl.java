package com.linktic.prueba_linktic.application.service.Impl;

import com.linktic.prueba_linktic.application.dto.LiquidationRequestDto;
import com.linktic.prueba_linktic.application.dto.LiquidationResponseDto;
import com.linktic.prueba_linktic.application.dto.ProtectionDto;
import com.linktic.prueba_linktic.application.service.ILiquidationService;
import com.linktic.prueba_linktic.domain.model.BonusModel;
import com.linktic.prueba_linktic.domain.model.ProtectionModel;
import com.linktic.prueba_linktic.infrastructure.adapters.repository.BonusRepository;
import com.linktic.prueba_linktic.infrastructure.adapters.repository.InsuredRepository;
import com.linktic.prueba_linktic.infrastructure.adapters.repository.ProtectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LiquidationServiceImpl implements ILiquidationService {

    private final InsuredRepository insuredRepository;
    private final ProtectionRepository protectionRepository;
    private final BonusRepository bonusRepository;

    @Override
    public LiquidationResponseDto calculateLiquidation(LiquidationRequestDto request) throws IllegalArgumentException {
        if (request.getInsuredValue().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException
                    ("The insured value must be greater than 0");
        }

        LiquidationResponseDto responseDto = new LiquidationResponseDto();
        responseDto.setIdentificationType(request.getIdentificationType());
        responseDto.setIdentificationNumber(request.getIdentificationNumber());
        responseDto.setInsuredValue(request.getInsuredValue());
        responseDto.setLiquidation(new ArrayList<>());
        BigDecimal totalValue = BigDecimal.ZERO;

        int age = calculateAge(request.getDateBirth());
        List<BonusModel> applicableBonuses = bonusRepository.findBonusByAge(age);

        for (BonusModel bonus : applicableBonuses) {
            try {
            BigDecimal bonusValue = request.getInsuredValue().multiply(bonus.getPercentageBonus());
            totalValue = totalValue.add(bonusValue);

            ProtectionModel protection = protectionRepository.findById(bonus.getCode())
                    .orElseThrow(() -> new RuntimeException("Protection was not found"));

            ProtectionDto protectionDto = new ProtectionDto();
            protectionDto.setCodeProtection(protection.getCode());
            protectionDto.setNameProtection(protection.getName());
            protectionDto.setValueBonus(bonusValue);

            responseDto.getLiquidation().add(protectionDto);
            } catch (RuntimeException ex) {
                System.out.println("Error finding protection: " + ex.getMessage());
            }
        }

        responseDto.setTotalvalue(totalValue);
        return responseDto;
    }

    private int calculateAge(LocalDate dateOfBirth) {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }


}
