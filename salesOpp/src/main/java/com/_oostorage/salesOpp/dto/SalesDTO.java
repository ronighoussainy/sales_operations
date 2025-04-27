package com._oostorage.salesOpp.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class SalesDTO {
    private Integer id;
    private Date creationDate;
    private Integer clientId;
    ClientsDTO clientsDTO;
    private Integer sellerId;
    SellersDTO sellersDTO;
    private Double total;
    List<SaleTransactionsDTO> saleTransactionsDTOList;
}
