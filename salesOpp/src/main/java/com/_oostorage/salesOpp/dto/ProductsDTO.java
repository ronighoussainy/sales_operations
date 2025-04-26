package com._oostorage.salesOpp.dto;

import lombok.Data;

import java.util.Date;
@Data
public class ProductsDTO {
    private Integer id;
    private String name;
    private String description;
    private String category;
    private Date creationDate;
}
