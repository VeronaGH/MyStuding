package com.testpro.library.domain.service;

import com.testpro.library.domain.model.Reader;
import com.testpro.library.domain.mongodb.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The class is served for saving, updating, deleting and looking up throw the Reader DB
 */
@Service
public class ReaderService {

    private final ReaderRepository readerRepository;

    @Autowired
    public ReaderService(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    /**
     * Save method
     *
     * @param reader class
     * @return reader
     */
    public Reader storeReader(Reader reader) {
        if (readerRepository.findFirstByNameAndSurname(reader.getName(), reader.getSurname()) == null) {
            return readerRepository.save(reader);
        }
        return null;
    }

    /**
     * Delete method
     *
     * @param reader class
     * @return reader
     */
    public Reader deleteReader(Reader reader) {
        if (readerRepository.findFirstByNameAndSurname(reader.getName(), reader.getSurname()) != null) {
            List<Reader> deleteReader = readerRepository.deleteReaderByNameAndSurname(reader.getName(), reader.getSurname());
            return deleteReader.get(0);
        }
        return null;
    }

    /**
     * find method. Try to find Readers by it's name and surname, if failed - tru to find by name or surname.
     * Finally, if couldn't try searching by it' s single params. And in case, when no params - send all Readers.
     *
     * @param reader Reader
     * @return List<Reader>
     */
    public List<Reader> findReader(Reader reader) {
        List<Reader> readerList;
        if ((reader.getName() != null) && (reader.getSurname() != null)) {
            readerList = readerRepository.findAllByNameAndSurname(reader.getName(), reader.getSurname());
            if (readerList.isEmpty()) {
                readerList = readerRepository.findAllByNameOrSurname(reader.getName(), reader.getSurname());
            }
            return readerList;
        }
        if (reader.getName() != null) {
            readerList = readerRepository.findAllByName(reader.getName());
            return readerList;
        }
        if (reader.getSurname() != null) {
            readerList = readerRepository.findAllBySurname(reader.getSurname());
            return readerList;
        }
        if (reader.getAddress() != null) {
            readerList = readerRepository.findAllByAddress(reader.getAddress());
            return readerList;
        }
        if (reader.getState() != null) {
            readerList = readerRepository.findAllByState(reader.getState());
            return readerList;
        }
        return readerRepository.findAll();
    }

    /**
     * this method updating appropriate entity at DB, if could find, else return nothing
     *
     * @param reader Reader
     * @return Reader class
     */
    public Reader updateReader(Reader reader) {
        Reader updatingReader = readerRepository.findFirstByNameAndSurname(reader.getName(), reader.getSurname());
        if (updatingReader != null) {
            return readerRepository.save(new Reader(
                    updatingReader.getId(),
                    reader.getName(),
                    reader.getSurname(),
                    reader.getAddress(),
                    reader.getState()));
        }
        return null;
    }

    /**
     * Return ID of entity from DB
     *
     * @param reader Reader
     * @return int ID
     */
    public int returnReaderId(Reader reader) {
        Reader searchReader = readerRepository.findOneByNameAndSurname(
                reader.getName(),
                reader.getSurname());
        if (searchReader != null) {
            return searchReader.getId();
        }
        return -1;
    }

    /**
     * Find reader by it's Id
     *
     * @param readerId int
     * @return Reader
     */
    public Reader findReaderById(int readerId) {
        return readerRepository.findOneById(readerId);

    }
}
