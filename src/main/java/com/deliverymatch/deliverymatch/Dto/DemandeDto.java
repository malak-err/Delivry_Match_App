package com.deliverymatch.deliverymatch.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DemandeDto {


    private Long id;
    private String dimension;
    private String poids;
    private String type ;
    private Long idExpediteur;
    private Long idTrajet;

}