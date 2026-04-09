package com.gestionformation.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.*;

@Entity
@Table(name = "formation")
@Data @NoArgsConstructor @AllArgsConstructor
public class Formation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le titre est obligatoire")
    @Column(nullable = false)
    private String titre;

    @NotNull(message = "L'année est obligatoire")
    @Min(value = 2000, message = "Année invalide")
    @Column(nullable = false)
    private Integer annee;

    @NotNull(message = "La durée est obligatoire")
    @Min(value = 1, message = "La durée doit être au moins 1 jour")
    @Column(nullable = false)
    private Integer duree;

    @NotNull(message = "Le budget est obligatoire")
    @Positive(message = "Le budget doit être positif")
    @Column(nullable = false)
    private Double budget;

    @ManyToOne
    @JoinColumn(name = "idDomaine", nullable = false)
    private Domaine domaine;

    @ManyToOne
    @JoinColumn(name = "idFormateur")
    private Formateur formateur;

    @ManyToMany
    @JoinTable(
            name = "formation_participant",
            joinColumns = @JoinColumn(name = "idFormation"),
            inverseJoinColumns = @JoinColumn(name = "idParticipant")
    )
    private List<Participant> participants = new ArrayList<>();
}