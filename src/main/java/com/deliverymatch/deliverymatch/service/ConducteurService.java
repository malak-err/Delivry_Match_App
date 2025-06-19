package com.deliverymatch.deliverymatch.service;


import com.deliverymatch.deliverymatch.Dto.ConducteurDto;
import com.deliverymatch.deliverymatch.Mapper.ConducteurMapper;
import com.deliverymatch.deliverymatch.Model.Conducteur;
import com.deliverymatch.deliverymatch.Model.Demande;
import com.deliverymatch.deliverymatch.Repository.ConducteurRipository;
import com.deliverymatch.deliverymatch.Repository.DemandeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ConducteurService {

    private final ConducteurRipository conducteurRipository;
    private final ConducteurMapper conducteurMapper;
    private final DemandeRepository demandeRepository;



    public ConducteurService(ConducteurRipository conducteurRipository, ConducteurMapper conducteurMapper , DemandeRepository demandeRepository) {
        this.conducteurRipository = conducteurRipository;
        this.conducteurMapper = conducteurMapper;
        this.demandeRepository = demandeRepository;
    }

    @Transactional
    public ConducteurDto create(ConducteurDto conducteurDto) {
        return conducteurMapper.conducteurToDto(conducteurRipository
                .save(conducteurMapper.dtoToConducteur(conducteurDto)));
    }


    public List<ConducteurDto> getAllConducteurs() {
        return conducteurRipository.findAll().stream()
                .map(conducteur->conducteurMapper.conducteurToDto(conducteur))
                .toList();
    }

    public ConducteurDto getConducteurById(Long id) {
        return conducteurRipository.findById(id)
                .map(conducteur->conducteurMapper.conducteurToDto(conducteur))
                .orElseThrow(()-> new  RuntimeException("aaaaaaaaaaaaaa"));
    }

    public ConducteurDto updateConducteur(ConducteurDto conducteurDto , Long id) {
        Conducteur conducteur = conducteurRipository.findById(id).get();
        conducteur.setEmail(conducteurDto.getEmail());
        conducteur.setFirstName(conducteurDto.getFirstName());
        conducteur.setLastName(conducteurDto.getLastName());

        return conducteurMapper.conducteurToDto(conducteurRipository
                .save(conducteurMapper.dtoToConducteur(conducteurDto)));
    }

    public void deleteConducteur(Long id) {
        conducteurRipository.deleteById(id);
    }

    public List<Demande> getDemandesReçues(Long conducteurId) {
        return demandeRepository.findByTrajetConducteurId(conducteurId);
    }
}
