package com._oostorage.salesOpp.mappers;


import com._oostorage.salesOpp.Entities.SaleTransactionsEntity;
import com._oostorage.salesOpp.dto.SaleTransactionsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface SaleTransactionsMapper {
    SaleTransactionsMapper INSTANCE = Mappers.getMapper(SaleTransactionsMapper.class);

    SaleTransactionsDTO saleTransactionsEntityToSaleTransactionsDTO(SaleTransactionsEntity saleTransactionsEntity);

    SaleTransactionsEntity saleTransactionsDTOToSaleTransactionsEntity(SaleTransactionsDTO saleTransactionsDTO);
}
