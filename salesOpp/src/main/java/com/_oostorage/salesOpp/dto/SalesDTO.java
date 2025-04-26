package com._oostorage.salesOpp.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class SalesDTO {
    private int id;
    private Date creationDate;
    private Integer clientId;
    private Integer sellerId;
    private BigDecimal total;
}
