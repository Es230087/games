package com.example.games.service;

import com.example.games.entity.Product;
import com.example.games.entity.ShoppingCart;
import com.example.games.exception.ShoppingCartNotFoundException;
import com.example.games.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public Iterable<ShoppingCart> findAll() {
        return shoppingCartRepository.findAll();
    }

    public Optional<ShoppingCart> findById(int shoppingCartId) {
        return shoppingCartRepository.findById(shoppingCartId);
    }

    public void updateShoppingCartTotal(ShoppingCart shoppingCart) {
        List<Product> productList = new ArrayList<>();
        productList.addAll(shoppingCart.getProductList());
        double shoppingCartTotal = 0.00;

        Optional<ShoppingCart> shoppingCartOptional = Optional.of(shoppingCart);
        if(shoppingCartOptional.isEmpty()) {
            throw new ShoppingCartNotFoundException("Shopping cart not found");
        }

        for (Product product : productList) {
            shoppingCartTotal = shoppingCartTotal + product.getProductPrice().doubleValue();
        }

        shoppingCart.setShoppingCartTotal(BigDecimal.valueOf(shoppingCartTotal));
    }

    public ShoppingCart save(ShoppingCart shoppingCart) {
        ShoppingCart savedShoppingCart = shoppingCartRepository.save(shoppingCart);

        return savedShoppingCart;
    }
}
