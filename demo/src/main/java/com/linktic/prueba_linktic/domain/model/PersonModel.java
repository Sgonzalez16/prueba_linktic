package com.linktic.prueba_linktic.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "persona")
public class PersonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero_identificacion", nullable = false, unique = true)
    private String identificationNumber;

    @Column(name = "nombre", nullable = false)
    private String name;

    @Column(name = "correo", nullable = false, unique = true)
    private String email;
}
