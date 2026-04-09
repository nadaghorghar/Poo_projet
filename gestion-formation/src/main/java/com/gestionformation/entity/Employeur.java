package com.gestionformation.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "employeur")
@Data @NoArgsConstructor @AllArgsConstructor
public class Employeur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Le nom de l'employeur est obligatoire")
    @Column(nullable = false)
    private String nomEmployeur;
}