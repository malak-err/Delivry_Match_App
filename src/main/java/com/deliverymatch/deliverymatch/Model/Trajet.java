package com.deliverymatch.deliverymatch.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Data
public class Trajet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String lieuDepart;
    private String etapesIntermediaire;
    private String destinationFinal;

    public Trajet(Long id, String lieuDepart, String etapesIntermediaire, String destinationFinal, String dimensionAccepte, String typeMarchandise, String capacite, Conducteur conducteur) {
        this.id = id;
        this.lieuDepart = lieuDepart;
        this.etapesIntermediaire = etapesIntermediaire;
        this.destinationFinal = destinationFinal;
        this.dimensionAccepte = dimensionAccepte;
        this.typeMarchandise = typeMarchandise;
        this.capacite = capacite;
        this.conducteur = conducteur;
    }

    private String dimensionAccepte;
    private String typeMarchandise;
    private String capacite;
    @ManyToOne
    private Conducteur conducteur;
    @OneToMany
    private List<Demande> demandes;







}
