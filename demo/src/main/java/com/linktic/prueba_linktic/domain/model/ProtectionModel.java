package com.linktic.prueba_linktic.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "amparos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProtectionModel {

    @Id
    @Column(name = "codigo")
    private Long code;

    @Column(name = "nombre")
    private String name;
}
