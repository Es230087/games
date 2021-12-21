package com.example.games.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "SHOPPING_CART")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer shoppingCartId;

    @Column(name = "CREATED_DATE")
    private LocalDate createdDate;

    @Column(name = "SHOPPING_CART_TOTAL")
    private BigDecimal shoppingCartTotal;

    @ManyToMany
    @JoinTable(
            name = "PRODUCT_SHOPPING_CART",
            joinColumns = @JoinColumn(name = "shoppingCartId"),
            inverseJoinColumns = @JoinColumn(name = "productId")
    )
    private List<Product> productList;
}
