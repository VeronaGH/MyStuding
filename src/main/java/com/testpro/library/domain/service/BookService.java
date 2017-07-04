package com.testpro.library.domain.service;

import com.testpro.library.domain.model.*;
import com.testpro.library.domain.mongodb.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Pigas on 27.06.2017.
 */
@Service
public class BookService {
    private final BookRepository bookRepository;
    private final IdService idService;

    @Autowired
    public BookService(BookRepository bookRepository, IdService idService) {
        this.bookRepository = bookRepository;
        this.idService = idService;
    }

    public Book storeBook(Book book) {
        return bookRepository.save(new Book(
                idService.incIdBook(),
                book.getLibraryId(),
                book.getName(),
                book.getAuthorId(),
                book.getGenreId(),
                book.getPublishingHouseId(),
                book.getYearPublish(),
                book.isBestSeller(),
                book.getDescription(),
                book.getState()));
    }


}
