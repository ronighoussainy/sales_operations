package com._oostorage.salesOpp.Entities;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name = "sale_transactions", schema = "sales_operations", catalog = "")
public class SaleTransactionsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "sale_id")
    private Integer saleId;
    @Basic
    @Column(name = "product_id")
    private Integer productId;
    @Basic
    @Column(name = "quantity")
    private Integer quantity;
    @Basic
    @Column(name = "price")
    private BigDecimal price;
}
