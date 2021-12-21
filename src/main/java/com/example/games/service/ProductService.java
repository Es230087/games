package com.example.games.service;

import com.example.games.entity.Product;
import com.example.games.exception.*;
import com.example.games.repository.ProductRepository;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> findByName(String productName) {
        Iterable<Product> productIterable = productRepository.findByProductName(productName);

        if (IterableUtils.size(productIterable) == 0) {
            throw new NameNotFoundException("Name not found");
        }

        return productIterable;
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findAllByProductCategory(String productCategory) {
        List<Product> productList = (List<Product>) productRepository.findAllByProductCategory(productCategory);

        if (productList.isEmpty() == true) {
            throw new CategoryNotFoundException("Category not found");
        }

        return productList;
    }

    public List<Product> findAllProductByInStockIsTrue() {
        List<Product> productList = productRepository.findAllByInStockIsTrue();

        return productList;
    }

    public Optional<Product> findByProductId(int id) {
        Optional<Product> productOptional = this.productRepository.findById(id);
        if(productOptional.isEmpty()) {
            throw new IdNotFoundException("ID not found");
        }

        return productOptional;
    }

    public List<Product> findAllByProductRarity(String productRarity) {
        List<Product> productListByRarity = productRepository.findAllByProductRarity(productRarity);
        if (productListByRarity.isEmpty()) {
            throw new RarityNotFoundException("Rarity not found");
        }

        return productListByRarity;
    }

    public List<Product> findAllByDeveloper(String developerName) {
        List<Product> productListByDeveloper = productRepository.findAllByDeveloper(developerName);
        if (productListByDeveloper.isEmpty()) {
            throw new DeveloperNotFoundException("Developer not found");
        }

        return productListByDeveloper;
    }

    public List<Product> findAllByPublisher(String publisherName) {
        List<Product> productListByPublisher = productRepository.findAllByPublisher(publisherName);
        if (productListByPublisher.isEmpty()) {
            throw new PublisherNotFoundException("Publisher not found");
        }

        return productListByPublisher;
    }

    public List<Product> findAllByReleaseDate(int releaseDate) {
        List<Product> productListByReleaseDate = productRepository.findAllByReleaseDate(releaseDate);

        if (productListByReleaseDate.isEmpty()) {
            throw new ReleaseDateNotFoundException("Release date not found");
        }

        return productListByReleaseDate;
    }

    public List<Product> findAllByGenre(String genre) {
        List<Product> productListByGenre = productRepository.findAllByGenre(genre);

        if (productListByGenre.isEmpty()) {
            throw new GenreNotFoundException("Genre not found");
        }

        return productListByGenre;
    }

    public List<Product> findAllBySystemRestriction(String systemRestriction) {
        List<Product> productList = productRepository.findAllBySystemRestriction(systemRestriction);

        if (productList.isEmpty()) {
            throw new SystemNotFoundException("System not found");
        }

        return productList;
    }
}
