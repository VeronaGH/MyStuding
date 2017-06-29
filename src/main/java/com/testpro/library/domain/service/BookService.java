package com.testpro.library.domain.service;

import com.testpro.library.domain.model.Book;
import com.testpro.library.domain.mongodb.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Pigas on 27.06.2017.
 */
@Component
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book storeBook (Book book) {
        return bookRepository.save(book);
    }


}
