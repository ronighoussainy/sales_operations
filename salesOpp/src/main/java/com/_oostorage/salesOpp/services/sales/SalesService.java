package com._oostorage.salesOpp.services.sales;

import com._oostorage.salesOpp.Entities.SaleTransactionLogsEntity;
import com._oostorage.salesOpp.dto.SaleTransactionLogsDTO;
import com._oostorage.salesOpp.dto.SalesDTO;

import java.util.List;
import java.util.Map;

public interface SalesService {
    List<SalesDTO> getSales();

    SalesDTO getOneSale(Integer id);

    Integer createSales(SalesDTO salesDTO);

    void updateSalesTransactions(List<Map<String, Object>> saleTransactionsDTOList);

    List<SaleTransactionLogsDTO> getSalesTransactionLogs();
}
