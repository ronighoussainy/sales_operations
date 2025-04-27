package com._oostorage.salesOpp.Entities;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "sales", schema = "sales_operations", catalog = "")
public class SalesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "creation_date")
    private Date creationDate = new Date();
    @Basic
    @Column(name = "client_id")
    private Integer clientId;
    @Basic
    @Column(name = "seller_id")
    private Integer sellerId;
    @Basic
    @Column(name = "total")
    private Double total = 0.0;

}
