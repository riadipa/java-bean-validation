package com.edu.dipa.java.validation.domain;


import com.edu.dipa.java.validation.BookValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BookTest {

    @Test
    void testValidationTrue() {
        Book testBook = new Book();
        testBook.setName("Jungle Book");

        Author author = new Author();
        author.setFirstname("Rudyard");
        testBook.setAuthor(author);

        BookValidator bookValidator = new BookValidator(testBook);

        bookValidator.validate();
    }

    @Test
    void testValidationThrowsIllegalArgumentException() {
        Book testBook = new Book();
        testBook.setName("Jungle Book");

        Author author = new Author();
        testBook.setAuthor(author);

        BookValidator bookValidator = new BookValidator(testBook);
        Assertions.assertThrows(IllegalArgumentException.class, bookValidator::validate);

    }

}