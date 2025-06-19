package com.deliverymatch.deliverymatch.Mapper;



import com.deliverymatch.deliverymatch.Dto.DemandeDto;
import com.deliverymatch.deliverymatch.Model.Demande;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring" , unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface DemandeMapper {

    DemandeDto ToDemandeDTO (Demande demande);
    Demande ToDemandeEntity (DemandeDto demandeDto);


}