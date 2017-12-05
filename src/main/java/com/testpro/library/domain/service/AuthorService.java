package com.testpro.library.domain.service;

import com.testpro.library.domain.model.Author;
import com.testpro.library.domain.mongodb.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * The class is served for saving, updating, deleting and looking up throw the Author DB
 */
@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    /**
     * Save method
     *
     * @param author class
     * @return library
     */
    public Author saveAuthor(Author author) {
        Author savingAuthor = authorRepository.findOneByNameAndSurnameAndYearOfBirth(
                author.getName(),
                author.getSurname(),
                author.getYearOfBirth());
        if (savingAuthor == null) {
            return authorRepository.save(author);
        } else {
            return null;
        }
    }

    /**
     * Delete all entity witch contain name, surname and year of birth.
     *
     * @param author class
     * @return List<Author>
     */
    public Author deleteAuthor(Author author) {
        List<Author> deletingAuthor = authorRepository.deleteByNameAndSurnameAndYearOfBirth(
                author.getName(),
                author.getSurname(),
                author.getYearOfBirth());
        if (!deletingAuthor.isEmpty()) {
            return deletingAuthor.get(0);
        }
        return null;
    }

    /**
     * This method look thro the Author DB and try to find list of entity by parameters:
     * name, surname, yearOfBirth. In case not sufficient data for search try to drop some parameters, and so on...
     *
     * @param author class
     * @return List<Author>
     */
    public List<Author> findAuthor(Author author) {
        List<Author> authorList;
        if (!StringUtils.isEmpty(author.getName()) && (!StringUtils.isEmpty(author.getSurname())) && !(author.getYearOfBirth() == 0)) {
            authorList = authorRepository.findAllByNameAndSurnameAndYearOfBirth(
                    author.getName(),
                    author.getSurname(),
                    author.getYearOfBirth());
            if (authorList.isEmpty()) {
                authorList = authorRepository.findAllByNameOrSurnameOrYearOfBirth(
                        author.getName(),
                        author.getSurname(),
                        author.getYearOfBirth());
            }
            return authorList;
        }
        if (!StringUtils.isEmpty(author.getName()) && (!StringUtils.isEmpty(author.getSurname()))) {
            authorList = authorRepository.findAllByNameAndSurname(
                    author.getName(),
                    author.getSurname());
            if (authorList.isEmpty()) {
                authorList = authorRepository.findAllByNameOrSurname(
                        author.getName(),
                        author.getSurname());
            }
            return authorList;
        }
        if (!StringUtils.isEmpty(author.getSurname())) {
            authorList = authorRepository.findAllBySurname(author.getSurname());
            return authorList;
        }
        if (!StringUtils.isEmpty(author.getName())) {
            authorList = authorRepository.findAllByName(author.getName());
            return authorList;
        }
        if (!(author.getYearOfBirth() == 0)) {
            authorList = authorRepository.findAllByYearOfBirth(author.getYearOfBirth());
            return authorList;
        }
        if (!StringUtils.isEmpty(author.getCitizenship())) {
            authorList = authorRepository.findAllByCitizenship(author.getCitizenship());
            return authorList;
        }
        return authorRepository.findAll();
    }

    /**
     * This method look thro the Author DB and try to find single entity by name, surname and yearOfbirth
     * if find - change other params
     *
     * @param author class
     * @return List<Author>
     */
    public Author updateAuthor(Author author) {
        Author updateAuthor = authorRepository.findOneByNameAndSurnameAndYearOfBirth(
                author.getName(),
                author.getSurname(),
                author.getYearOfBirth());
        if (updateAuthor != null) {
            return authorRepository.save(new Author(
                    updateAuthor.getId(),
                    author.getName(),
                    author.getSurname(),
                    author.getYearOfBirth(),
                    author.getCitizenship(),
                    author.getBiography(),
                    author.isStillAlive()));
        }
        return null;
    }

    /**
     * Return ID of entity from DB
     *
     * @param author Author
     * @return int ID
     */
    public int returnAuthorId(Author author) {
        Author searchAuthor = authorRepository.findOneByNameAndSurnameAndYearOfBirth(
                author.getName(),
                author.getSurname(),
                author.getYearOfBirth());
        if (searchAuthor != null) {
            return searchAuthor.getId();
        }
        return -1;
    }

    /**
     * Find entity in DB by it's ID
     *
     * @param id int
     * @return author Author
     */
    public Author findAuthorByID(int id) {
        Author author = authorRepository.findOneById(id);
        if (author != null) {
            return author;
        }
        return null;
    }

}
