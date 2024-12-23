package com.cqrs.cqrs.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {
    private String id;
    private String name;
    private String description;
    private double price;
    private int stock;

}
