package com.deliverymatch.deliverymatch.Mapper;



import com.deliverymatch.deliverymatch.Dto.ExpediteurDto;
import com.deliverymatch.deliverymatch.Model.Expediteur;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring" , unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ExpediteurMapper {

    ExpediteurDto ToExpediteurDto (Expediteur expediteur);
    Expediteur ToExpediteurEntity (ExpediteurDto expediteurDto);
}
