package com.example.games.controller;

import com.example.games.entity.Product;
import com.example.games.entity.ShoppingCart;
import com.example.games.exception.ShoppingCartNotFoundException;
import com.example.games.service.ProductService;
import com.example.games.service.ShoppingCartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;
    private final ProductService productService;

    public ShoppingCartController(ShoppingCartService shoppingCartService, ProductService productService) {
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
    }

    //Get all shopping carts
    @GetMapping("/shoppingCart")
    public Iterable<ShoppingCart> getAllShoppingCarts() {
        return shoppingCartService.findAll();
    }

    //Find a specific shopping cart
    @GetMapping("/shoppingCart/{shoppingCartId}")
    public Optional<ShoppingCart> findShoppingCart(@PathVariable int shoppingCartId) {
        Optional<ShoppingCart> shoppingCartOptional = shoppingCartService.findById(shoppingCartId);

        if(shoppingCartOptional.isEmpty()) {
            throw new ShoppingCartNotFoundException("Shopping cart not found");
        }

        return shoppingCartService.findById(shoppingCartId);
    }

    //Create a shopping cart
    @PostMapping(value = "/shoppingCart", produces = MediaType.APPLICATION_JSON_VALUE)
    public ShoppingCart createNewShoppingCart(@RequestBody Product product) {
        Optional<Product> productOptional = this.productService.findByProductId(product.getProductId());

        if (productOptional.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        } else {
            ShoppingCart shoppingCart = new ShoppingCart();
            shoppingCart.setCreatedDate(LocalDate.now());
            shoppingCart.setShoppingCartTotal(BigDecimal.valueOf(0.00));
            List<Product> productList = new ArrayList<>();
            productList.add(productOptional.get());
            shoppingCart.setProductList(productList);
            shoppingCartService.updateShoppingCartTotal(shoppingCart);
            ShoppingCart savedShoppingCart = shoppingCartService.save(shoppingCart);

            return savedShoppingCart;
        }
    }

    //Add product to shopping cart
    @PutMapping("/shoppingCart/{shoppingCartId}/product")
    public ShoppingCart addProductToShoppingCart(@PathVariable Integer shoppingCartId, @RequestBody Product product) {
        Optional<ShoppingCart> shoppingCartOptional = shoppingCartService.findById(shoppingCartId);

        if(shoppingCartOptional.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);

        }

        Optional<Product> productOptional = productService.findByProductId(product.getProductId());

        if(productOptional.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }

        ShoppingCart tempCart = shoppingCartOptional.get();
        tempCart.getProductList().add(productOptional.get());
        shoppingCartService.updateShoppingCartTotal(tempCart);
        ShoppingCart savedShoppingCart = shoppingCartService.save(tempCart);

        return savedShoppingCart;
    }

    //Delete product from shopping cart
    @DeleteMapping("/shoppingCart/{shoppingCartId}/product/{productId}")
    public ResponseEntity deleteProductFromShoppingCart(@PathVariable Integer shoppingCartId, @PathVariable Integer productId) {
        Optional<ShoppingCart> shoppingCartOptional = shoppingCartService.findById(shoppingCartId);

        if (shoppingCartOptional.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }

        Optional<Product> productOptional = productService.findByProductId(productId);

        if (productOptional.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }

        Product productToBeDeleted = productOptional.get();
        boolean containProduct = shoppingCartOptional.get().getProductList().contains(productToBeDeleted);
        if (containProduct) {
            ShoppingCart shoppingCart = shoppingCartOptional.get();
            shoppingCart.getProductList().remove(productToBeDeleted);
            shoppingCartService.updateShoppingCartTotal(shoppingCart);
            shoppingCartService.save(shoppingCart);

            return ResponseEntity.noContent().build();
        } else {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }
    }






}
