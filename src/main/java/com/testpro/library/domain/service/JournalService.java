package com.testpro.library.domain.service;

import com.testpro.library.domain.model.Journal;
import com.testpro.library.domain.mongodb.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The class is served for saving, updating, deleting and looking up throw the Journal DB
 */
@Service
public class JournalService {
    private final JournalRepository journalRepository;
    private final IdService idService;

    @Autowired
    public JournalService(JournalRepository journalRepository, IdService idService) {
        this.journalRepository = journalRepository;
        this.idService = idService;
    }

    /**
     * Save method
     *
     * @param journal Journal
     * @return Journal
     */
    public Journal storeJournal(Journal journal) {
        List<Journal> searchingJournal = journalRepository.findAllByLibraryIdAndBookIdAndReaderIdAndDayTaken(
                journal.getLibraryId(),
                journal.getBookId(),
                journal.getReaderId(),
                journal.getDayTaken());
        if (searchingJournal.isEmpty() && (journal.getDayReturn() != null) && (journal.getDayTaken() != null)) {
            return journalRepository.save(new Journal(
                    idService.incIdJournal(),
                    journal.getLibraryId(),
                    journal.getBookId(),
                    journal.getDayTaken(),
                    journal.getDayReturn(),
                    journal.getReaderId()));
        }
        return null;
    }

    /**
     * Find Journal in DB by amount of parameters
     *
     * @param journal Journal
     * @return List<Journal>
     */
    public List<Journal> findJournal(Journal journal) {
        List<Journal> journals = journalRepository.findAllByLibraryIdAndBookIdAndReaderIdAndDayTaken(
                journal.getLibraryId(),
                journal.getBookId(),
                journal.getReaderId(),
                journal.getDayTaken());
        if (journals.isEmpty() && (journal.getReaderId() != 0)) {
            journals = journalRepository.findAllByReaderId(journal.getReaderId());
        }
        if (journals.isEmpty() && (journal.getBookId() != 0)) {
            journals = journalRepository.findAllByBookId(journal.getReaderId());
        }
        if (journals.isEmpty() && (journal.getLibraryId() != 0)) {
            journals = journalRepository.findAllByLibraryId(journal.getReaderId());
        }
        if (journals.isEmpty()) {
            journals = journalRepository.findAll();
        }
        return journals;
    }

    /**
     * Delete journal from DB if find by library, book and reader
     *
     * @param journal Journal
     * @return Journal
     */
    public Journal deleteJournal(Journal journal) {
        List<Journal> deletingJournal = journalRepository.findAllByLibraryIdAndBookIdAndReaderIdAndDayTaken(
                journal.getLibraryId(),
                journal.getBookId(),
                journal.getReaderId(),
                journal.getDayTaken());
        if (deletingJournal.size() == 1) {
            return journalRepository.deleteById(deletingJournal.get(0).getId());
        }
        return null;
    }

    /**
     * Update journal entity in DB if could find it in DB by library, book and reader
     *
     * @param journal Journal
     * @return List<Journal>
     */
    public List<Journal> updateJournal(Journal journal) {
        List<Journal> journals = findJournal(journal);
        if (journals.size() == 1) {
            List<Journal> newJournals = new ArrayList<Journal>();
            newJournals.add(journalRepository.save(new Journal(
                    newJournals.get(0).getId(),
                    journal.getLibraryId(),
                    journal.getBookId(),
                    journal.getDayTaken(),
                    journal.getDayReturn(),
                    journal.getReaderId())));
            return newJournals;
        } else {
            return journals;
        }

    }
}
