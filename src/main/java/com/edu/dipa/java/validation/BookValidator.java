package com.edu.dipa.java.validation;

import com.edu.dipa.java.validation.domain.Author;
import com.edu.dipa.java.validation.domain.Book;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

public class BookValidator extends CustomValidator<Book> {

    public BookValidator(Book book) {
        super(book);
    }

    @NotNull(message = "Author must not be null")
    public Author getAuthor() {
        return getTarget().getAuthor();
    }

    @AssertTrue(message = "Author first name should not be null")
    public boolean isAuthorFirstnameNotNull() {
        return getTarget().getAuthor().getFirstname() != null;
    }
}
