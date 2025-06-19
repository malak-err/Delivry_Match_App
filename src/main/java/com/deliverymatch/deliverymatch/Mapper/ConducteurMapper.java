package com.deliverymatch.deliverymatch.Mapper;



import com.deliverymatch.deliverymatch.Dto.ConducteurDto;
import com.deliverymatch.deliverymatch.Model.Conducteur;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring" , unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ConducteurMapper {

    ConducteurDto conducteurToDto(Conducteur conducteur);
    Conducteur dtoToConducteur(ConducteurDto conducteurDto);

}


