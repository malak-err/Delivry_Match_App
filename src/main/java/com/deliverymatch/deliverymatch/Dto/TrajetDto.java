package com.deliverymatch.deliverymatch.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrajetDto {

    private Long id;
    private String lieuDepart;
    private String etapesIntermediaire;
    private String destinationFinal;
    private String dimensionAccepte;
    private String typeMarchandise;
    private String capacite;
    private Long conducteurId ;
}
