package com._oostorage.salesOpp.mappers;

import com._oostorage.salesOpp.Entities.ProductsEntity;
import com._oostorage.salesOpp.dto.ProductsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductsMapper {
    ProductsMapper INSTANCE = Mappers.getMapper(ProductsMapper.class);

    ProductsDTO productsEntityToProductsDTO(ProductsEntity productsEntity);

    ProductsEntity productsDTOToProductsEntity(ProductsDTO productsDTO);

}


