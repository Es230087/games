package com.example.games.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Integer productId;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRODUCT_CATEGORY")
    private String productCategory;

    @Column(name = "GENRE")
    private String genre;

    @Column(name = "PRODUCT_DESCRIPTION")
    private String productDescription;

    @Column(name = "PRODUCT_RARITY")
    private String productRarity;

    @Column(name = "PRODUCT_DEVELOPER")
    private String developer;

    @Column(name = "PRODUCT_PUBLISHER")
    private String publisher;

    @Column(name = "RELEASE_DATE")
    private Integer releaseDate;

    @Column(name = "PRODUCT_PRICE")
    private BigDecimal productPrice;

    @Column(name = "SYSTEM_RESTRICTION")
    private String systemRestriction;

    @Column(name = "IN_STOCK")
    private Boolean inStock;

    @JsonIgnore
    @ManyToMany(mappedBy = "productList")
    private List<ShoppingCart> shoppingCartList;
}
