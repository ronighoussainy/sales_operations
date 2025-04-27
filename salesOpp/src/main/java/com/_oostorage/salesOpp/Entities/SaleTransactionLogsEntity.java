package com._oostorage.salesOpp.Entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

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
    private BigDecimal oldPrice;
    @Basic
    @Column(name = "new_price")
    private BigDecimal newPrice;
    @Basic
    @Column(name = "update_time")
    private Timestamp updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getOldQuantity() {
        return oldQuantity;
    }

    public void setOldQuantity(Integer oldQuantity) {
        this.oldQuantity = oldQuantity;
    }

    public Integer getNewQuantity() {
        return newQuantity;
    }

    public void setNewQuantity(Integer newQuantity) {
        this.newQuantity = newQuantity;
    }

    public BigDecimal getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(BigDecimal oldPrice) {
        this.oldPrice = oldPrice;
    }

    public BigDecimal getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(BigDecimal newPrice) {
        this.newPrice = newPrice;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleTransactionLogsEntity that = (SaleTransactionLogsEntity) o;
        return id == that.id && Objects.equals(transactionId, that.transactionId) && Objects.equals(oldQuantity, that.oldQuantity) && Objects.equals(newQuantity, that.newQuantity) && Objects.equals(oldPrice, that.oldPrice) && Objects.equals(newPrice, that.newPrice) && Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transactionId, oldQuantity, newQuantity, oldPrice, newPrice, updateTime);
    }
}
