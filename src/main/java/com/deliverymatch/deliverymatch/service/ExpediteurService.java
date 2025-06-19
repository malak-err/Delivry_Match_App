package com.deliverymatch.deliverymatch.service;



import com.deliverymatch.deliverymatch.Dto.ExpediteurDto;
import com.deliverymatch.deliverymatch.Mapper.ExpediteurMapper;
import com.deliverymatch.deliverymatch.Model.Expediteur;
import com.deliverymatch.deliverymatch.Repository.ExpediteurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ExpediteurService {

    public final ExpediteurRepository expediteurRepository ;
    public final ExpediteurMapper expediteurMapper ;


    @Transactional
    public ExpediteurDto createExpediteur(ExpediteurDto expediteurDto) {
        return expediteurMapper.ToExpediteurDto(expediteurRepository.save(expediteurMapper.ToExpediteurEntity(expediteurDto)));
    }


    public List<ExpediteurDto> getAllExpediteur() {
        return expediteurRepository.findAll().stream()
                .map(expediteur->expediteurMapper.ToExpediteurDto(expediteur))
                .toList();
    }

    public ExpediteurDto getExpediteurById(Long id){
        return expediteurRepository.findById(id)
                .map(expediteurMapper::ToExpediteurDto)
                .orElseThrow(()->new RuntimeException("not found"));
    }

    public ExpediteurDto updateEx (ExpediteurDto expediteurDto , Long id){
        Expediteur expediteur = expediteurRepository.findById(id).get();
        expediteur.setEmail(expediteurDto.getEmail());
        expediteur.setFirstName(expediteurDto.getFirstName());
        expediteur.setLastName(expediteurDto.getLastName());

        return expediteurMapper.ToExpediteurDto(expediteurRepository.save(expediteurMapper.ToExpediteurEntity(expediteurDto)));
    }

    public void deleteExpediteur(Long id){
        expediteurRepository.deleteById(id);
    }




}
