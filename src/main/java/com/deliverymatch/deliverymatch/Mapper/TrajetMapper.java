package com.deliverymatch.deliverymatch.Mapper;

import com.deliverymatch.deliverymatch.Dto.TrajetDto;
import com.deliverymatch.deliverymatch.Model.Trajet;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring" , unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TrajetMapper {

    TrajetDto toTrajetDto(Trajet trajet);
    Trajet toTrajet(TrajetDto trajetDto);
}
