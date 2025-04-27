package com._oostorage.salesOpp.mappers;

import com._oostorage.salesOpp.Entities.SalesEntity;
import com._oostorage.salesOpp.dto.SalesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper( unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SalesMapper {
    SalesMapper INSTANCE = Mappers.getMapper(SalesMapper.class);

    SalesDTO salesEntityToSalesDTO(SalesEntity salesEntity);

    SalesEntity salesDTOToSalesEntity(SalesDTO salesDTO);
}
