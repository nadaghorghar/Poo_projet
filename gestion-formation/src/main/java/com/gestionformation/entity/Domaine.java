package com.gestionformation.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "domaine")
@Data @NoArgsConstructor @AllArgsConstructor
public class Domaine {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Le libellé est obligatoire")
    @Column(nullable = false, unique = true)
    private String libelle;
}