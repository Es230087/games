package com.example.games.serviceTest;

import com.example.games.entity.Product;
import com.example.games.entity.ShoppingCart;
import com.example.games.repository.ShoppingCartRepository;
import com.example.games.service.ShoppingCartService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class shoppingCartServiceTest {

    @Mock
    private ShoppingCartRepository shoppingCartRepository;
    @InjectMocks
    private ShoppingCartService shoppingCartService;

    //find all shopping carts
    @Test
    public void findAllShoppingCarts_success() {
        //setup
        ShoppingCart expectedShoppingCart = new ShoppingCart();
        expectedShoppingCart.setShoppingCartId(1);
        expectedShoppingCart.setCreatedDate(LocalDate.now());
        expectedShoppingCart.setShoppingCartTotal(BigDecimal.valueOf(0.00));

        Product expectedProduct = new Product();
        expectedProduct.setProductId(1);
        expectedProduct.setProductName("nameOfProduct");
        expectedProduct.setProductCategory("categoryOfProduct");
        expectedProduct.setProductDescription("productDescription");
        expectedProduct.setProductRarity("productRarity");
        expectedProduct.setDeveloper("developer");
        expectedProduct.setPublisher("publisher");
        expectedProduct.setReleaseDate(1999);
        expectedProduct.setProductPrice(BigDecimal.valueOf(10.00));
        expectedProduct.setSystemRestriction("systemRestriction");
        expectedProduct.setInStock(true);

        List<Product> listOfProductsIterable = new ArrayList<>();
        listOfProductsIterable.add(expectedProduct);
        expectedShoppingCart.setProductList(listOfProductsIterable);

        Iterable<ShoppingCart> shoppingCartIterable = Arrays.asList(expectedShoppingCart);
        when(shoppingCartRepository.findAll()).thenReturn(shoppingCartIterable);

        //execute
        Iterable<ShoppingCart> actualShoppingCartIterable = shoppingCartService.findAll();

        //assert
        assertEquals(shoppingCartIterable, actualShoppingCartIterable);
    }

    //find by id
    @Test
    public void findByID_withValidId_success() {
        //setup
        ShoppingCart expectedShoppingCart = new ShoppingCart();
        expectedShoppingCart.setShoppingCartId(1);
        expectedShoppingCart.setCreatedDate(LocalDate.now());
        expectedShoppingCart.setShoppingCartTotal(BigDecimal.valueOf(0.00));

        Optional<ShoppingCart> shoppingCartOptional = Optional.of(expectedShoppingCart);
        when(shoppingCartRepository.findById(expectedShoppingCart.getShoppingCartId())).thenReturn(shoppingCartOptional);

        //execute
        Optional<ShoppingCart> actualShoppingCartOptional = shoppingCartService.findById(expectedShoppingCart.getShoppingCartId());

        //assert
        assertEquals(expectedShoppingCart.getShoppingCartId(), actualShoppingCartOptional.get().getShoppingCartId());
    }

    //update shopping cart total
    @Test
    public void updateShoppingCartTotal_withValidProduct_success() {
        //setup
        ShoppingCart expectedShoppingCart = new ShoppingCart();
        expectedShoppingCart.setShoppingCartId(1);
        expectedShoppingCart.setCreatedDate(LocalDate.now());
        expectedShoppingCart.setShoppingCartTotal(BigDecimal.valueOf(0.00));
        expectedShoppingCart.setProductList(new ArrayList<>());

        Product expectedProduct = new Product();
        expectedProduct.setProductId(1);
        expectedProduct.setProductName("nameOfProduct");
        expectedProduct.setProductCategory("categoryOfProduct");
        expectedProduct.setProductDescription("productDescription");
        expectedProduct.setProductRarity("productRarity");
        expectedProduct.setDeveloper("developer");
        expectedProduct.setPublisher("publisher");
        expectedProduct.setReleaseDate(1999);
        expectedProduct.setProductPrice(BigDecimal.valueOf(10.00));
        expectedProduct.setSystemRestriction("systemRestriction");
        expectedProduct.setInStock(true);

        Double shoppingCartTotalBeforeUpdate = expectedShoppingCart.getShoppingCartTotal().doubleValue();

        expectedShoppingCart.getProductList().add(expectedProduct);

        //execute
        shoppingCartService.updateShoppingCartTotal(expectedShoppingCart);

        Double shoppingCartTotalAfterUpdate = expectedShoppingCart.getShoppingCartTotal().doubleValue();

        //assert
        assertNotEquals(shoppingCartTotalBeforeUpdate, shoppingCartTotalAfterUpdate);

    }
}
