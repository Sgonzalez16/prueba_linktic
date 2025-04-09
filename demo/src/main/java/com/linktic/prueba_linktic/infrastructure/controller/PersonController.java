package com.linktic.prueba_linktic.infrastructure.controller;

import com.linktic.prueba_linktic.application.dto.PersonRequestDto;
import com.linktic.prueba_linktic.application.service.IPersonService;
import com.linktic.prueba_linktic.domain.model.PersonModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
@RequiredArgsConstructor
public class PersonController {

    private final IPersonService iPersonService;

    @PostMapping
    public ResponseEntity<PersonModel> savePerson(@RequestBody PersonRequestDto dto) {
        PersonModel saved = iPersonService.savePerson(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/{identificationNumber}")
    public ResponseEntity<PersonModel> getPerson(@PathVariable String identificationNumber) {
        return iPersonService.getPersonByIdentification(identificationNumber)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
