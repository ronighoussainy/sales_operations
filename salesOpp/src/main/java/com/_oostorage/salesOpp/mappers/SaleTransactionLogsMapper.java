package com._oostorage.salesOpp.mappers;

import com._oostorage.salesOpp.Entities.SaleTransactionLogsEntity;
import com._oostorage.salesOpp.dto.SaleTransactionLogsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SaleTransactionLogsMapper {
    SaleTransactionLogsMapper INSTANCE = Mappers.getMapper(SaleTransactionLogsMapper.class);

    SaleTransactionLogsDTO saleTransactionLogsEntityToSaleTransactionLogsDTO(SaleTransactionLogsEntity saleTransactionLogsEntity);

    SaleTransactionLogsEntity saleTransactionLogsDTOToSaleTransactionLogsEntity(SaleTransactionLogsDTO saleTransactionLogsDTO);
}
