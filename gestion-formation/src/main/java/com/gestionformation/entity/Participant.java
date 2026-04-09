package com.gestionformation.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "participant")
@Data @NoArgsConstructor @AllArgsConstructor
public class Participant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Le nom est obligatoire")
    @Column(nullable = false)
    private String nom;

    @NotBlank(message = "Le prénom est obligatoire")
    @Column(nullable = false)
    private String prenom;

    @Email(message = "Email invalide")
    @Column(nullable = false, unique = true)
    private String email;

    @Pattern(regexp = "^[0-9]{8}$", message = "Numéro de téléphone invalide (8 chiffres)")
    private String tel;

    @ManyToOne
    @JoinColumn(name = "idStructure", nullable = false)
    private Structure structure;

    @ManyToOne
    @JoinColumn(name = "idProfil", nullable = false)
    private Profil profil;
}