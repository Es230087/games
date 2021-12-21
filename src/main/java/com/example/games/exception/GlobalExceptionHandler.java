package com.example.games.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = HttpClientErrorException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage clientErrorException(HttpClientErrorException exception, WebRequest request) {
        HttpStatus httpStatusCode = exception.getStatusCode();
        ErrorMessage message = new ErrorMessage(
                httpStatusCode.value(),
                new Date(),
                exception.getMessage(),
                request.getDescription(true));

        return message;
    }

    @ExceptionHandler(value = IdNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "ID not found")
    public ErrorMessage clientErrorExceptionIdNotFound(IdNotFoundException exception, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                exception.getMessage(),
                request.getDescription(false));

        return message;
    }

    @ExceptionHandler(value = ShoppingCartNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Shopping cart not found")
    public ErrorMessage clientErrorExceptionShoppingCartNotFound(ShoppingCartNotFoundException exception, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                exception.getMessage(),
                request.getDescription(false));

        return message;
    }

    @ExceptionHandler(value = CategoryNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Category not found")
    public ErrorMessage clientErrorExceptionCategoryNotFound(CategoryNotFoundException exception, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                exception.getMessage(),
                request.getDescription(false));

        return message;
    }

    @ExceptionHandler(value = PublisherNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Publisher not found")
    public ErrorMessage clientErrorExceptionPublisherNotFound(PublisherNotFoundException exception, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                exception.getMessage(),
                request.getDescription(false));

        return message;
    }

    @ExceptionHandler(value = DeveloperNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Developer not found")
    public ErrorMessage clientErrorExceptionDeveloperNotFound(DeveloperNotFoundException exception, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                exception.getMessage(),
                request.getDescription(false));

        return message;
    }

    @ExceptionHandler(value = RarityNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Rarity not found")
    public ErrorMessage clientErrorExceptionRarityNotFound(RarityNotFoundException exception, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                exception.getMessage(),
                request.getDescription(false));

        return message;
    }

    @ExceptionHandler(value = GenreNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Genre not found")
    public ErrorMessage clientErrorExceptionGenreNotFound(GenreNotFoundException exception, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                exception.getMessage(),
                request.getDescription(false));

        return message;
    }

    @ExceptionHandler(value = NameNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Name not found")
    public ErrorMessage clientErrorExceptionNameNotFound(NameNotFoundException exception, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                exception.getMessage(),
                request.getDescription(false));

        return message;
    }

    @ExceptionHandler(value = SystemNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "System not found")
    public ErrorMessage clientErrorExceptionSystemNotFound(SystemNotFoundException exception, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                exception.getMessage(),
                request.getDescription(false));

        return message;
    }

    @ExceptionHandler(value = ReleaseDateNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Release date not found")
    public ErrorMessage clientErrorExceptionReleaseDateNotFound(ReleaseDateNotFoundException exception, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                exception.getMessage(),
                request.getDescription(false));

        return message;
    }
}
