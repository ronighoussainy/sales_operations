package com._oostorage.salesOpp.Entities;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "products", schema = "sales_operations")
public class ProductsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "category")
    private String category;
    @Basic
    @Column(name = "creation_date")
    private Date creationDate = new Date();

}
