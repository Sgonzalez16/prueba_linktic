package com.linktic.prueba_linktic.infrastructure.adapters.repository;

import com.linktic.prueba_linktic.domain.model.BonusModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BonusRepository extends JpaRepository<BonusModel, Long> {

    @Query("SELECT p FROM BonusModel p WHERE :edad >= p.minimumAge AND :edad <= p.maximumAge")
    List<BonusModel> findBonusByAge(@Param("edad") int edad);
}
