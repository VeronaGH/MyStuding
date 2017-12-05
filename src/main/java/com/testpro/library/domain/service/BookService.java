package com.testpro.library.domain.service;

import com.testpro.library.domain.model.Book;
import com.testpro.library.domain.mongodb.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The class is served for saving, updating, deleting and looking up throw the Book DB
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

    /**
     * Save method
     *
     * @param book class
     * @return Book
     */
    public Book storeBook(Book book) {
        List<Book> searchingBook = bookRepository.findAllByLibraryIdAndNameAndAuthorIdAndYearPublish(
                book.getLibraryId(),
                book.getName(),
                book.getAuthorId(),
                book.getYearPublish());
        if (searchingBook.isEmpty() && (book.getLibraryId() != -1) && (book.getAuthorId() != -1)) {
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
        return null;
    }

    /**
     * Find Book in DB by amount of parameters
     *
     * @param book Book
     * @return List<Book>
     */
    public List<Book> findBook(Book book) {
        List<Book> books;
        if (book.getLibraryId() == -1){
            books = bookRepository.findAllByNameAndAuthorIdAndYearPublish(
                    book.getName(),
                    book.getAuthorId(),
                    book.getYearPublish());
        } else {
            books = bookRepository.findAllByLibraryIdAndNameAndAuthorIdAndYearPublish(
                    book.getLibraryId(),
                    book.getName(),
                    book.getAuthorId(),
                    book.getYearPublish());
        }
        if (books.isEmpty() && (book.getName() != null)) {
            books = bookRepository.findAllByName(book.getName());
        }
        if (books.isEmpty() && (book.getAuthorId() != 0)) {
            books = bookRepository.findAllByAuthorId(book.getAuthorId());
        }
        if (books.isEmpty() && (book.getLibraryId() != 0)) {
            books = bookRepository.findAllByLibraryId(book.getLibraryId());
        }
        if (books.isEmpty()) {
            books = bookRepository.findAll();
        }
        return books;
    }

    /**
     * Delete book in DB if find by library, name, author and year of publishing
     *
     * @param book Book
     * @return Book
     */
    public Book deleteBook(Book book) {
        List<Book> deletingBook = bookRepository.findAllByLibraryIdAndNameAndAuthorIdAndYearPublish(
                book.getLibraryId(),
                book.getName(),
                book.getAuthorId(),
                book.getYearPublish());
        if (!deletingBook.isEmpty() && (book.getLibraryId() != -1) && (book.getAuthorId() != -1)) {
            return bookRepository.deleteAllByLibraryIdAndNameAndAuthorIdAndYearPublish(
                    book.getLibraryId(),
                    book.getName(),
                    book.getAuthorId(),
                    book.getYearPublish()).get(0);
        }
        return null;
    }

    /**
     * Update book entity in DB if could find it in DB by library, name, author and year of publishing
     *
     * @param book Book
     * @return List<Book>
     */
    public List<Book> updateBook(Book book) {
        List<Book> books = findBook(book);
        if (books.size() == 1) {
            List<Book> newBooks = new ArrayList<Book>();
            newBooks.add(bookRepository.save(new Book(
                    books.get(0).getId(),
                    book.getLibraryId(),
                    book.getName(),
                    book.getAuthorId(),
                    book.getGenreId(),
                    book.getPublishingHouseId(),
                    book.getYearPublish(),
                    book.isBestSeller(),
                    book.getDescription(),
                    book.getState())));
            return newBooks;
        } else {
            return books;
        }

    }

    /**
     * Return ID of entity from DB
     *
     * @param book Book
     * @return int ID
     */
    public int returnBookId(Book book) {
        Book searchBook = bookRepository.findOneByLibraryIdAndNameAndAuthorIdAndYearPublish(
                book.getLibraryId(),
                book.getName(),
                book.getAuthorId(),
                book.getYearPublish());
        if (searchBook != null) {
            return searchBook.getId();
        }
        return -1;
    }

    /**
     * Find book by ID
     *
     * @param bookId int
     * @return Book
     */
    public Book findBookById(int bookId) {
        return bookRepository.findById(bookId);
    }
}
