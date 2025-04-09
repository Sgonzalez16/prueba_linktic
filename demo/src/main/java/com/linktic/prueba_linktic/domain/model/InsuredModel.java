package com.linktic.prueba_linktic.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "asegurados")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsuredModel {

    @Id
    @Column(name = "numero_identificacion")
    private Long identificationNumber;

    @Column(name = "tipo_identificacion")
    private int identificationType;

    @Column(name = "apellidos")
    private String surnames;

    @Column(name = "nombres")
    private String names;

    @Column(name = "sexo")
    private int sex;

    @Column(name = "fecha_nacimiento")
    private LocalDate birthDate;
}
