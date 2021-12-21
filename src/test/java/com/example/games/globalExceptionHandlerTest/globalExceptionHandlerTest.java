package com.example.games.globalExceptionHandlerTest;

import com.example.games.exception.*;
import org.h2.command.dml.MergeUsing;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class globalExceptionHandlerTest {

    private final GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

    //client error exception
    @Test
    public void clientErrorException_withClientErrorException_success() {

        //setup
        HttpClientErrorException httpClientErrorException = new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Test message");
        WebRequest webRequest = Mockito.mock(WebRequest.class);
        when(webRequest.getDescription(true)).thenReturn("Test string");

        //execute
        ErrorMessage actualErrorMessage = globalExceptionHandler.clientErrorException(httpClientErrorException, webRequest);

        //assert
        assertEquals(httpClientErrorException.getStatusCode().value(), actualErrorMessage.getStatusCode());
        assertEquals(httpClientErrorException.getMessage(), actualErrorMessage.getMessage());
        assertEquals(webRequest.getDescription(true), actualErrorMessage.getDescription());
    }

    //category not found exception
    @Test
    public void clientErrorExceptionCategoryNotFound_withClientErrorException_success() {

        //setup
        CategoryNotFoundException categoryNotFoundException = new CategoryNotFoundException("Test message");
        WebRequest webRequest = Mockito.mock(WebRequest.class);
        when(webRequest.getDescription(false)).thenReturn("Test string");

        //execute
        ErrorMessage actualErrorMessage = globalExceptionHandler.clientErrorExceptionCategoryNotFound(categoryNotFoundException, webRequest);

        //assert
        int expectedStatusCodeValue = HttpStatus.NOT_FOUND.value();
        assertEquals(expectedStatusCodeValue, actualErrorMessage.getStatusCode());
        assertEquals(categoryNotFoundException.getMessage(), actualErrorMessage.getMessage());
        assertEquals(webRequest.getDescription(false), actualErrorMessage.getDescription());
    }

    //developer not found exception
    @Test
    public void clientErrorExceptionDeveloperNotFound_withClientErrorException_success() {

        //setup
        DeveloperNotFoundException developerNotFoundException = new DeveloperNotFoundException("Test message");
        WebRequest webRequest = Mockito.mock(WebRequest.class);
        when(webRequest.getDescription(false)).thenReturn("Test string");

        //execute
        ErrorMessage actualErrorMessage = globalExceptionHandler.clientErrorExceptionDeveloperNotFound(developerNotFoundException, webRequest);

        //assert
        int expectedStatusCodeValue = HttpStatus.NOT_FOUND.value();
        assertEquals(expectedStatusCodeValue, actualErrorMessage.getStatusCode());
        assertEquals(developerNotFoundException.getMessage(), actualErrorMessage.getMessage());
        assertEquals(webRequest.getDescription(false), actualErrorMessage.getDescription());
    }

    //genre not found exception
    @Test
    public void clientErrorExceptionGenreNotFound_withClientErrorException_success() {

        //setup
        GenreNotFoundException genreNotFoundException = new GenreNotFoundException("Test message");
        WebRequest webRequest = Mockito.mock(WebRequest.class);
        when(webRequest.getDescription(false)).thenReturn("Test string");

        //execute
        ErrorMessage actualErrorMessage = globalExceptionHandler.clientErrorExceptionGenreNotFound(genreNotFoundException, webRequest);

        //assert
        int expectedStatusCodeValue = HttpStatus.NOT_FOUND.value();
        assertEquals(expectedStatusCodeValue, actualErrorMessage.getStatusCode());
        assertEquals(genreNotFoundException.getMessage(), actualErrorMessage.getMessage());
        assertEquals(webRequest.getDescription(false), actualErrorMessage.getDescription());
    }

    //id not found exception
    @Test
    public void clientErrorExceptionIdNotFound_withClientErrorException_success() {

        //setup
        IdNotFoundException idNotFoundException = new IdNotFoundException("Test message");
        WebRequest webRequest = Mockito.mock(WebRequest.class);
        when(webRequest.getDescription(false)).thenReturn("Test string");

        //execute
        ErrorMessage actualErrorMessage = globalExceptionHandler.clientErrorExceptionIdNotFound(idNotFoundException, webRequest);

        //assert
        int expectedStatusCodeValue = HttpStatus.NOT_FOUND.value();
        assertEquals(expectedStatusCodeValue, actualErrorMessage.getStatusCode());
        assertEquals(idNotFoundException.getMessage(), actualErrorMessage.getMessage());
        assertEquals(webRequest.getDescription(false), actualErrorMessage.getDescription());
    }

    //name not found exception
    @Test
    public void clientErrorExceptionNameNotFound_withClientErrorException_success() {

        //setup
        NameNotFoundException nameNotFoundException = new NameNotFoundException("Test message");
        WebRequest webRequest = Mockito.mock(WebRequest.class);
        when(webRequest.getDescription(false)).thenReturn("Test string");

        //execute
        ErrorMessage actualErrorMessage = globalExceptionHandler.clientErrorExceptionNameNotFound(nameNotFoundException, webRequest);

        //assert
        int expectedStatusCodeValue = HttpStatus.NOT_FOUND.value();
        assertEquals(expectedStatusCodeValue, actualErrorMessage.getStatusCode());
        assertEquals(nameNotFoundException.getMessage(), actualErrorMessage.getMessage());
        assertEquals(webRequest.getDescription(false), actualErrorMessage.getDescription());
    }

    //publisher not found exception
    @Test
    public void clientErrorExceptionPublisherNotFound_withClientErrorException_success() {

        //setup
        PublisherNotFoundException publisherNotFoundException = new PublisherNotFoundException("Test message");
        WebRequest webRequest = Mockito.mock(WebRequest.class);
        when(webRequest.getDescription(false)).thenReturn("Test string");

        //execute
        ErrorMessage actualErrorMessage = globalExceptionHandler.clientErrorExceptionPublisherNotFound(publisherNotFoundException, webRequest);

        //assert
        int expectedStatusCodeValue = HttpStatus.NOT_FOUND.value();
        assertEquals(expectedStatusCodeValue, actualErrorMessage.getStatusCode());
        assertEquals(publisherNotFoundException.getMessage(), actualErrorMessage.getMessage());
        assertEquals(webRequest.getDescription(false), actualErrorMessage.getDescription());
    }

    //rarity not found exception
    @Test
    public void clientErrorExceptionRarityNotFound_withClientErrorException_success() {

        //setup
        RarityNotFoundException rarityNotFoundException = new RarityNotFoundException("Test message");
        WebRequest webRequest = Mockito.mock(WebRequest.class);
        when(webRequest.getDescription(false)).thenReturn("Test string");

        //execute
        ErrorMessage actualErrorMessage = globalExceptionHandler.clientErrorExceptionRarityNotFound(rarityNotFoundException, webRequest);

        //assert
        int expectedStatusCodeValue = HttpStatus.NOT_FOUND.value();
        assertEquals(expectedStatusCodeValue, actualErrorMessage.getStatusCode());
        assertEquals(rarityNotFoundException.getMessage(), actualErrorMessage.getMessage());
        assertEquals(webRequest.getDescription(false), actualErrorMessage.getDescription());
    }

    //release date not found exception
    @Test
    public void clientErrorExceptionReleaseDatNotFound_withClientErrorException() {

        //setup
        ReleaseDateNotFoundException releaseDateNotFoundException = new ReleaseDateNotFoundException("Test message");
        WebRequest webRequest = Mockito.mock(WebRequest.class);
        when(webRequest.getDescription(false)).thenReturn("Test string");

        //execute
        ErrorMessage actualErrorMessage = globalExceptionHandler.clientErrorExceptionReleaseDateNotFound(releaseDateNotFoundException, webRequest);

        //assert
        int expectedStatusCodeValue = HttpStatus.NOT_FOUND.value();
        assertEquals(expectedStatusCodeValue, actualErrorMessage.getStatusCode());
        assertEquals(releaseDateNotFoundException.getMessage(), actualErrorMessage.getMessage());
        assertEquals(webRequest.getDescription(false), actualErrorMessage.getDescription());
    }

    //shopping cart not found exception
    @Test
    public void clientErrorExceptionShoppingCartNotFound_withClientErrorException() {

        //setup
        ShoppingCartNotFoundException shoppingCartNotFoundException = new ShoppingCartNotFoundException("Test message");
        WebRequest webRequest = Mockito.mock(WebRequest.class);
        when(webRequest.getDescription(false)).thenReturn("Test string");

        //execute
        ErrorMessage actualErrorMessage = globalExceptionHandler.clientErrorExceptionShoppingCartNotFound(shoppingCartNotFoundException, webRequest);

        //assert
        int expectedStatusCodeValue = HttpStatus.NOT_FOUND.value();
        assertEquals(expectedStatusCodeValue, actualErrorMessage.getStatusCode());
        assertEquals(shoppingCartNotFoundException.getMessage(), actualErrorMessage.getMessage());
        assertEquals(webRequest.getDescription(false), actualErrorMessage.getDescription());
    }

    //system not found exception
    @Test
    public void clientErrorMessageSystemNotFound_withClientErrorException() {

        //setup
        SystemNotFoundException systemNotFoundException = new SystemNotFoundException("Test message");
        WebRequest webRequest = Mockito.mock(WebRequest.class);
        when(webRequest.getDescription(false)).thenReturn("Test string");

        //execute
        ErrorMessage actualErrorMessage = globalExceptionHandler.clientErrorExceptionSystemNotFound(systemNotFoundException, webRequest);

        //assert
        int expectedStatusCodeValue = HttpStatus.NOT_FOUND.value();
        assertEquals(expectedStatusCodeValue, actualErrorMessage.getStatusCode());
        assertEquals(systemNotFoundException.getMessage(), actualErrorMessage.getMessage());
        assertEquals(webRequest.getDescription(false), actualErrorMessage.getDescription());
    }
}
