package com.linktic.prueba_linktic.infrastructure.adapters.repository;

import com.linktic.prueba_linktic.domain.model.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonModel, Integer> {
    Optional<PersonModel> findByIdentificationNumber(String identificationNumber);
}
