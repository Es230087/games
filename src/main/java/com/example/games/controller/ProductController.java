package com.example.games.controller;

import com.example.games.entity.Product;
import com.example.games.exception.SystemNotFoundException;
import com.example.games.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    //Get all products
    @GetMapping("/products")
    public Iterable<Product> findAllProducts(@RequestParam(required = false) String productName) {
        Iterable<Product> productIterable;

        if (productName != null) {
            productIterable = this.productService.findByName(productName);
        } else {
            productIterable = this.productService.findAll();
        }

        return productIterable;
    }

    //Search by product name
    @GetMapping("/productName/{productName}")
    public Iterable<Product> findProductByName(@PathVariable String productName) {
        Iterable<Product> productIterable = productService.findByName(productName);

        return productIterable;
    }

    //Search by product category
    @GetMapping("/productCategory/{productCategory}")
    public List<Product> findProductByCategory(@PathVariable String productCategory) {
        List<Product> productList = productService.findAllByProductCategory(productCategory);

        return productList;
    }

    //Search by system restriction
    @GetMapping("/systemRestriction/{systemRestriction}")
    public List<Product> findBySystemRestriction(@PathVariable String systemRestriction) {
        List<Product> productList = productService.findAllBySystemRestriction(systemRestriction);

        if (productList.isEmpty()) {
            throw new SystemNotFoundException("System not found");
        }

        return  productList;
    }

    //Search by all products in stock
    @GetMapping("/inStock")
    public List<Product> findAllProductsInStockIsTrue() {
        List<Product> productList = productService.findAllProductByInStockIsTrue();

        return productList;
    }

    //Search by product rarity
    @GetMapping("/productRarity/{productRarity}")
    public List<Product> findAllProductsByRarity(@PathVariable String productRarity) {
        List<Product> productListByRarity = productService.findAllByProductRarity(productRarity);

        return productListByRarity;
    }

    //Search by publisher
    @GetMapping("/publisher/{publisher}")
    public List<Product> findAllByPublisher(@PathVariable String publisher) {
        List<Product> productListByPublisher = productService.findAllByPublisher(publisher);

        return productListByPublisher;
    }

    //search by developer
    @GetMapping("/developer/{developer}")
    public List<Product> findAllByDeveloper(@PathVariable String developer) {
        List<Product> productListByDeveloper = productService.findAllByDeveloper(developer);

        return productListByDeveloper;
    }

    //search by year released
    @GetMapping("/releaseDate/{releaseDate}")
    public List<Product> findAllByReleaseDate(@PathVariable int releaseDate) {
        List<Product> productListByReleaseDate = productService.findAllByReleaseDate(releaseDate);

        return productListByReleaseDate;
    }

    //search by genre
    @GetMapping("/genre/{genre}")
    public List<Product> findAllByGenre(@PathVariable String genre) {
        List<Product> productListByGenre = productService.findAllByGenre(genre);

        return productListByGenre;
    }
}
