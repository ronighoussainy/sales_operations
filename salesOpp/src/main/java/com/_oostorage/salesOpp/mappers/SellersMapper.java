package com._oostorage.salesOpp.mappers;

import com._oostorage.salesOpp.Entities.SellersEntity;
import com._oostorage.salesOpp.dto.SellersDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface SellersMapper {
   SellersMapper INSTANCE = Mappers.getMapper(SellersMapper.class);

   SellersDTO sellersEntityToSellersDTO(SellersEntity sellersEntity);

   SellersEntity sellersDTOToSellersEntity(SellersDTO sellersDTO);
}
