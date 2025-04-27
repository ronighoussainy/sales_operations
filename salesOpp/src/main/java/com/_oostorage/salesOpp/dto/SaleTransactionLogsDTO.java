package com._oostorage.salesOpp.dto;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;

@Data
public class SaleTransactionLogsDTO {
    private Integer id;

    private Integer transactionId;

    private Integer oldQuantity;

    private Integer newQuantity;

    private Double oldPrice;

    private Double newPrice;

    private Date updateTime;

}