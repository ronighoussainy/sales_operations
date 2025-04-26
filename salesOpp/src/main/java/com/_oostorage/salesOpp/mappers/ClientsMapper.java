package com._oostorage.salesOpp.mappers;

import com._oostorage.salesOpp.Entities.ClientsEntity;
import com._oostorage.salesOpp.dto.ClientsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientsMapper {
    ClientsMapper INSTANCE = Mappers.getMapper(ClientsMapper.class);


   ClientsDTO clientsEntityToClientsDTO(ClientsEntity clientsEntity);


    ClientsEntity clientsDTOToClientsEntity(ClientsDTO clientsDTO);

}
