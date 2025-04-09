package com.linktic.prueba_linktic.application.service.impl;

import com.linktic.prueba_linktic.application.dto.PersonRequestDto;
import com.linktic.prueba_linktic.application.service.IPersonService;
import com.linktic.prueba_linktic.domain.model.PersonModel;
import com.linktic.prueba_linktic.infrastructure.adapters.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements IPersonService {

    private final PersonRepository personRepository;


    @Override
    public PersonModel savePerson(PersonRequestDto personDto) {
        PersonModel personModel = new PersonModel();
        personModel.setIdentificationNumber(personDto.getIdentificationNumber());
        personModel.setName(personDto.getName());
        personModel.setEmail(personDto.getEmail());
        return personRepository.save(personModel);
    }

    @Override
    public Optional<PersonModel> getPersonByIdentification(String identificationNumber) {
        return personRepository.findByIdentificationNumber(identificationNumber);
    }
}
