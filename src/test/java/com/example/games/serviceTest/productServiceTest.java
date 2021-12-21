package com.example.games.serviceTest;

import com.example.games.entity.Product;
import com.example.games.exception.*;
import com.example.games.repository.ProductRepository;
import com.example.games.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class productServiceTest {

    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductService productService;

    //find all
    @Test
    public void findAll_withReturnValue_success() {
        //setup
        Product product = Mockito.mock(Product.class);
        Iterable<Product> expectedProductIterable = List.of(product);
        when(productRepository.findAll()).thenReturn(expectedProductIterable);

        //execute
        Iterable<Product> actualProductIterable = productService.findAll();

        //assert
        assertEquals(expectedProductIterable.iterator().next(), actualProductIterable.iterator().next());

    }

    //find all by system
    @Test
    public void findAllBySystem_WithValidSystem_Success() {
        //setup
        String nameOfSystem = "Super Nintendo";
        Product expectedProduct = new Product();
        expectedProduct.setProductName("Name of game");
        expectedProduct.setSystemRestriction("Super Nintendo");
        List<Product> expectedProductList = new ArrayList<>();
        expectedProductList.add(expectedProduct);
        when(productRepository.findAllBySystemRestriction(nameOfSystem)).thenReturn(expectedProductList);

        //execute
        List<Product> actualProductList = productService.findAllBySystemRestriction(nameOfSystem);

        //assert
        assertEquals(expectedProductList, actualProductList);
    }

    //System not found exception with valid name but no results found
    @Test
    public void findBySystem_withValidSystemNameAndSystemNotFound_throwsSystemNotFoundException() {
        //setup
        String systemSearch = "Sega Genesis";
        Product expectedProduct = new Product();
        expectedProduct.setProductName("Name of game");
        expectedProduct.setProductCategory("Game");
        expectedProduct.setSystemRestriction("Super Nintendo");
        List<Product> expectedProductList = new ArrayList<>();
        expectedProductList.add(expectedProduct);
        when(productRepository.findAllBySystemRestriction(systemSearch)).thenReturn(List.of());

        //execute
        SystemNotFoundException actualException = assertThrows(SystemNotFoundException.class, () ->
                productService.findAllBySystemRestriction(systemSearch)
        );

        String expectedMessage = "System not found";
        String actualMessage = actualException.getMessage();

        //assert
        assertEquals(expectedMessage, actualMessage);
    }

    //find by name
    @Test
    public void findByName_withValidName_success() {
        //setup
        Product expectedProduct = new Product();
        expectedProduct.setProductName("Name Of Game");
        expectedProduct.setProductCategory("Game");
        Iterable<Product> expectedProductIterable = List.of(expectedProduct);
        when(productRepository.findByProductName(expectedProduct.getProductName())).thenReturn(expectedProductIterable);

        //execute
        Iterable<Product> actualProductIterable = productService.findByName(expectedProductIterable.iterator().next().getProductName());

        //assert
        assertEquals(expectedProductIterable.iterator().next().getProductName(), actualProductIterable.iterator().next().getProductName());
    }

    //Name not found exception with valid name but no results found
    @Test
    public void findByName_withValidNameAndNameNotFound_throwsNameNotFoundException() {
        //setup
        String searchName = "Golf";
        Product expectedProduct = new Product();
        expectedProduct.setProductName("Basketball");

        when(productRepository.findByProductName(searchName)).thenReturn(List.of());

        //execute
        NameNotFoundException actualException = assertThrows(NameNotFoundException.class, () ->
                productService.findByName(searchName)
        );

        String expectedMessage = "Name not found";
        String actualMessage = actualException.getMessage();

        //assert
        assertEquals(expectedMessage, actualMessage);
    }

    //find all by category
    @Test
    public void findAllByCategory_withValidCategory_success() {
        //setup
        String categorySearchName = "Game";
        Product expectedProduct = new Product();
        expectedProduct.setProductName("NameOfGame");
        expectedProduct.setProductCategory("Game");
        List<Product> expectedProductIterable = List.of(expectedProduct);
        when(productRepository.findAllByProductCategory(categorySearchName)).thenReturn(expectedProductIterable);

        //execute
        Iterable<Product> actualProductIterable = productService.findAllByProductCategory(categorySearchName);

        //assert
        assertEquals(expectedProductIterable.iterator().next().getProductCategory(), actualProductIterable.iterator().next().getProductCategory());
    }

    //Category not found exception with valid Category name but no results found
    @Test
    public void findAllByCategory_withValidCategoryAndCategoryNotFound_throwsCategoryNotFoundException() {
        //setup
        String searchCategory = "Import Games";
        Product expectedProduct = new Product();
        expectedProduct.setProductName("Controller");
        expectedProduct.setProductCategory("Accessory");

        when(productRepository.findAllByProductCategory(searchCategory)).thenReturn(List.of());

        //execute
        CategoryNotFoundException actualException = assertThrows(CategoryNotFoundException.class, () ->
                productService.findAllByProductCategory(searchCategory)
        );

        String expectedMessage = "Category not found";
        String actualMessage = actualException.getMessage();

        //assert
        assertEquals(expectedMessage, actualMessage);
    }

    //find all by inStock
    @Test
    public void findAllByInStock_withValidValueIdTrue_success() {
        //setup
        //boolean inStock = true;
        Product expectedProduct = new Product();
        expectedProduct.setInStock(true);
        expectedProduct.setProductName("NameOfGame");

        List<Product> expectedProductList = new ArrayList<>();
        expectedProductList.add(expectedProduct);

        when(productRepository.findAllByInStockIsTrue()).thenReturn(expectedProductList);

        //execute
        List<Product> actualListOfProducts = productService.findAllProductByInStockIsTrue();

        //assert
        assertSame(expectedProduct, actualListOfProducts.get(0));
    }

    //find all by rarity
    @Test
    public void findAllByRarity_withValidValue_success() {
        //setup
        String rarity = "Rare";
        Product expectedProduct = new Product();
        expectedProduct.setProductName("nameOfGame");
        expectedProduct.setProductRarity("Rare");
        List<Product> expectedProductIterable = List.of(expectedProduct);
        when(productRepository.findAllByProductRarity(rarity)).thenReturn(expectedProductIterable);

        //execute
        Iterable<Product> actualProductIterable = productService.findAllByProductRarity(rarity);

        //assert
        assertEquals(expectedProductIterable.iterator().next().getProductRarity(), actualProductIterable.iterator().next().getProductRarity());
    }

    //Rarity not found exception with valid rarity but no results found
    @Test
    public void findAllByRarity_withValidRarityAndRarityNotFound_throwsRarityNotFound() {
        String rarity = "Super Rare";
        Product expectedProduct = new Product();
        expectedProduct.setProductRarity("Common");

        when(productRepository.findAllByProductRarity(rarity)).thenReturn(List.of());

        //execute
        RarityNotFoundException actualException = assertThrows(RarityNotFoundException.class, () ->
                productService.findAllByProductRarity(rarity)
        );

        String expectedMessage = "Rarity not found";
        String actualMessage = actualException.getMessage();

        //assert
        assertEquals(expectedMessage, actualMessage);
    }

    //find all by developer
    @Test
    public void findAllByDeveloper_withValidValue_success() {
        //setup
        String nameOfDeveloper = "Nintendo";
        Product expectedProduct = new Product();
        expectedProduct.setProductName("nameOfGame");
        expectedProduct.setDeveloper("Nintendo");
        List<Product> expectedProductIterable = List.of(expectedProduct);
        when(productRepository.findAllByDeveloper(nameOfDeveloper)).thenReturn(expectedProductIterable);

        //execute
        Iterable<Product> actualProductIterable = productService.findAllByDeveloper(nameOfDeveloper);

        //assert
        assertEquals(expectedProductIterable.iterator().next().getDeveloper(), actualProductIterable.iterator().next().getDeveloper());
    }

    //Developer not found exception with valid developer but no results found
    @Test
    public void findAllByDeveloper_withValidDeveloperAndDeveloperNotFound_throwsDeveloperNotFound() {
        //setup
        String developerSearch = "Sega";
        Product expectedProduct = new Product();
        expectedProduct.setDeveloper("Nintendo");

        when(productRepository.findAllByDeveloper(developerSearch)).thenReturn(List.of());

        //execute
        DeveloperNotFoundException actualException = assertThrows(DeveloperNotFoundException.class, () ->
                productService.findAllByDeveloper(developerSearch)
        );

        String expectedMessage = "Developer not found";
        String actualMessage = actualException.getMessage();

        //assert
        assertEquals(expectedMessage, actualMessage);
    }

    //find all by publisher
    @Test
    public void findAllByPublisher_withValidValue_success() {
        String nameOfPublisher = "Nintendo";
        Product expectedProduct = new Product();
        expectedProduct.setProductName("nameOfGame");
        expectedProduct.setPublisher("Nintendo");
        List<Product> expectedProductIterable = List.of(expectedProduct);
        when(productRepository.findAllByPublisher(nameOfPublisher)).thenReturn(expectedProductIterable);

        //execute
        Iterable<Product> actualProductIterable = productService.findAllByPublisher(nameOfPublisher);

        //assert
        assertEquals(expectedProductIterable.iterator().next().getPublisher(), actualProductIterable.iterator().next().getPublisher());
    }

    //Publisher not found with valid publisher but no results found
    @Test
    public void findAllByPublisher_withValidPublisherAndPublisherNotFound_throwsPublisherNotFound() {
        String nameOfPublisher = "Nintendo";
        Product expectedProduct = new Product();
        expectedProduct.setPublisher("Sega");

        when(productRepository.findAllByPublisher(nameOfPublisher)).thenReturn(List.of());

        //execute
        PublisherNotFoundException actualException = assertThrows(PublisherNotFoundException.class, () ->
                productService.findAllByPublisher(nameOfPublisher)
        );

        String expectedMessage = "Publisher not found";
        String actualMessage = actualException.getMessage();

        //assert
        assertEquals(expectedMessage, actualMessage);
    }

    //find all by release date
    @Test
    public void findAllByReleaseDate_withValidValue_success() {
        int searchDate = 1997;
        Product expectedProduct = new Product();
        expectedProduct.setProductName("nameOfGame");
        expectedProduct.setReleaseDate(1997);
        List<Product> expectedProductIterable = List.of(expectedProduct);
        when(productRepository.findAllByReleaseDate(searchDate)).thenReturn(expectedProductIterable);

        //execute
        Iterable<Product> actualProductIterable = productService.findAllByReleaseDate(searchDate);

        //assert
        assertEquals(expectedProductIterable.iterator().next().getReleaseDate(), actualProductIterable.iterator().next().getReleaseDate());
    }

    //Release date not found with valid release date but no results found
    @Test
    public void findAllByReleaseDate_withValidReleaseDateAndReleaseDateFound_throwsReleaseNotFound() {
        int searchDate = 1995;
        Product expectedProduct = new Product();
        expectedProduct.setReleaseDate(1999);

        when(productRepository.findAllByReleaseDate(searchDate)).thenReturn(List.of());

        //execute
        ReleaseDateNotFoundException actualException = assertThrows(ReleaseDateNotFoundException.class, ()->
                productService.findAllByReleaseDate(searchDate)
        );

        String expectedMessage = "Release date not found";
        String actualMessage = actualException.getMessage();

        //assert
        assertEquals(expectedMessage, actualMessage);
    }

    //find all by genre
    @Test
    public void findAllByGenre_withValidValue_success() {
        String searchGenre = "Action";
        Product expectedProduct = new Product();
        expectedProduct.setProductName("nameOfGame");
        expectedProduct.setGenre("Action");
        List<Product> expectedProductIterable = List.of(expectedProduct);
        when(productRepository.findAllByGenre(searchGenre)).thenReturn(expectedProductIterable);

        //execute
        Iterable<Product> actualProductIterable = productService.findAllByGenre(searchGenre);

        //assert
        assertEquals(expectedProductIterable.iterator().next().getGenre(), actualProductIterable.iterator().next().getGenre());
    }

    //Genre not found exception with valid genre but no results found
    @Test
    public void findAllByGenre_withValidGenreAndGenreNotFound_throwsGenreNotFoundException() {
        String searchGenre = "Puzzle";
        Product expectedProduct = new Product();
        expectedProduct.setGenre("Action");

        when(productRepository.findAllByGenre(searchGenre)).thenReturn(List.of());

        //execute
        GenreNotFoundException actualException = assertThrows(GenreNotFoundException.class, () ->
                productService.findAllByGenre(searchGenre)
        );

        String expectedMessage = "Genre not found";
        String actualMessage = actualException.getMessage();

        //assert
        assertEquals(expectedMessage, actualMessage);
    }
}
