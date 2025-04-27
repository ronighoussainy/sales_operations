package com._oostorage.salesOpp.dto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class SaleTransactionsDTO {
    private Integer id;
    private Integer saleId;
    private Integer productId;
    private Integer quantity;
    private Double price;
}
