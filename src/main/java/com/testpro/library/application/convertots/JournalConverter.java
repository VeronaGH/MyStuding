package com.testpro.library.application.convertots;

import com.testpro.library.application.dto.BookDTO;
import com.testpro.library.application.dto.JournalDTO;
import com.testpro.library.domain.model.Book;
import com.testpro.library.domain.model.Journal;
import com.testpro.library.domain.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Converter class for entity Journal
 */
@Component
public class JournalConverter {

    private final LibraryService libraryService;
    private final BookService bookService;
    private final ReaderService readerService;
    private final BookConverter bookConverter;

    @Autowired
    public JournalConverter(LibraryService libraryService, BookService bookService, ReaderService readerService, BookConverter bookConverter) {
        this.libraryService = libraryService;
        this.bookService = bookService;
        this.readerService = readerService;
        this.bookConverter = bookConverter;
    }

    /**
     * Convert  JournalDTO object to Book object
     *
     * @return Journal
     */
    public Journal convertToJournal(JournalDTO journalDTO) {
        return new Journal(
                0,
                libraryService.returnLibraryId(new LibraryConverter().convertToLibrary(journalDTO.getLibraryDTO())),
                bookService.returnBookId(bookConverter.convertToBook(journalDTO.getBookDTO())),
                journalDTO.getDayTaken(),
                journalDTO.getDayReturn(),
                readerService.returnReaderId(new ReaderConverter().convertToReader(journalDTO.getReaderDTO())));
    }

    /**
     * Convert  Journal object to JournalDTO object
     *
     * @param journal Journal
     * @return JournalDTO
     */
    public JournalDTO convertToJournalDTO(Journal journal) {
        if (journal == null) {
            return null;
        }
        return new JournalDTO(
                new LibraryConverter().convertToLibraryDTO(libraryService.findLibraryById(journal.getLibraryId())),
                bookConverter.convertToBookDTO(bookService.findBookById(journal.getBookId())),
                journal.getDayTaken(),
                journal.getDayReturn(),
                new ReaderConverter().convertToReaderDTO(readerService.findReaderById(journal.getReaderId())));
    }

    /**
     * Convert  List<Journal> object to List<JournalDTO> object
     *
     * @param journalList List<Journal>
     * @return List<JournalDTO>
     */
    public List<JournalDTO> convertToJournalDTOList(List<Journal> journalList) {
        if (journalList == null) {
            return null;
        }
        List<JournalDTO> journalDTOList = new ArrayList<JournalDTO>();
        for (Journal journal : journalList) {
            journalDTOList.add(convertToJournalDTO(journal));
        }
        return journalDTOList;
    }
}
