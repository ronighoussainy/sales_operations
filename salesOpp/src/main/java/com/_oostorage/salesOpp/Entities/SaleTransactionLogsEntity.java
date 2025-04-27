package com._oostorage.salesOpp.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@Entity
@Table(name = "sale_transaction_logs", schema = "sales_operations", catalog = "")
public class SaleTransactionLogsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "transaction_id")
    private Integer transactionId;
    @Basic
    @Column(name = "old_quantity")
    private Integer oldQuantity;
    @Basic
    @Column(name = "new_quantity")
    private Integer newQuantity;
    @Basic
    @Column(name = "old_price")
    private Double oldPrice;
    @Basic
    @Column(name = "new_price")
    private Double newPrice;
    @Basic
    @Column(name = "update_time")
    private Date updateTime;

}
