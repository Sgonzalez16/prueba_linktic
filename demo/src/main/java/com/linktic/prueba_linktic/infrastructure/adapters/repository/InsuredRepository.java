package com.linktic.prueba_linktic.infrastructure.adapters.repository;

import com.linktic.prueba_linktic.domain.model.InsuredModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuredRepository extends JpaRepository<InsuredModel, Integer> {
}
