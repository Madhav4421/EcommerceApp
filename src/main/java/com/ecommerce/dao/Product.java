package com.ecommerce.dao;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="gadget")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String prodModel;

}

