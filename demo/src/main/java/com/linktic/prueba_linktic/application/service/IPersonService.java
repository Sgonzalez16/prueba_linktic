package com.linktic.prueba_linktic.application.service;

import com.linktic.prueba_linktic.application.dto.PersonRequestDto;
import com.linktic.prueba_linktic.domain.model.PersonModel;

import java.util.Optional;

public interface IPersonService {

    PersonModel savePerson(PersonRequestDto personDto);

    Optional<PersonModel> getPersonByIdentification(String identificationNumber);
}
