package com.example.games.repository;

import com.example.games.entity.Product;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    Iterable<Product> findByProductName(String productName);
    List<Product> findAllByProductCategory(String productCategory);
    List<Product> findAllByInStockIsTrue();
    List<Product> findAllByProductRarity(String productRarity);
    List<Product> findAllByDeveloper(String developerName);
    List<Product> findAllByPublisher(String publisherName);
    List<Product> findAllByReleaseDate(int releaseDate);
    List<Product> findAllByGenre(String genre);
    List<Product> findAllBySystemRestriction(String system);
}
