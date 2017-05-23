package com.testpro.library.domain.service;

import com.testpro.library.domain.model.Author;
import com.testpro.library.domain.mongodb.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Test service containing methods initial creating db AuthorRepository and testing asses methods.
 */
@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void init() {
        authorRepository.deleteAll();

        authorRepository.save(new Author(1,
                "Paul",
                "Jenkins",
                1985,
                "United States of America",
                "Long, long, long story with happy end...",
                true));

        authorRepository.save(new Author(2,
                "Luke",
                "Mirigam",
                1961,
                "United States of America",
                "Long, long, long story without pappy end...",
                false));

        authorRepository.save(new Author(3,
                "David",
                "Ferko",
                1955,
                "United Kingdom of Grate Britain",
                "Middle hand novel autor.",
                false));

        authorRepository.save(new Author(4,
                "Mihail",
                "Veller",
                1967,
                "Soviet Republic",
                "Genius author of soviet prose",
                true));

        authorRepository.save(new Author(5,
                "Omar",
                "Haiam",
                1000,
                "Arabian East",
                "Genius ancient Arabic author",
                false));

        authorRepository.save(new Author(6,
                "David",
                "Fresto",
                1985,
                "New Zeland",
                "Quiet boy from a remote province",
                true));

        authorRepository.save(new Author(7,
                "Mishel",
                "Fresto",
                1980,
                "New Zeland",
                "A brother of a quiet boy from a remote province",
                true));

        System.out.println("Initialisation complete...");
    }

    public void check() {

        System.out.println("Printing all data from db");
        final List<Author> allauthors = authorRepository.findAll();
        for (Author author : allauthors) {
            System.out.print("Line №" + allauthors.indexOf(author) + ": ");
            System.out.println(author.toString());
        }
        System.out.println("Printing lines from db with name 'David': ");
        final List<Author> namedAuthor = authorRepository.findAllByName("David");
        for (Author author : namedAuthor) {
            System.out.print("Line №" + (namedAuthor.indexOf(author) + 1) + ": ");
            System.out.println(author.toString());
        }

        System.out.println("Printing lines from db with surname 'Fresto': ");
        final List<Author> surnamedAuthor = authorRepository.findAllBySurname("Fresto");
        for (Author author : surnamedAuthor) {
            System.out.print("Line №" + surnamedAuthor.indexOf(author) + ": ");
            System.out.println(author.toString());
        }

        System.out.println("Printing lines from db with parameters:" +
                " year of birth, name, surname (Omar Haiam, 1000): ");
        System.out.println(authorRepository.findByNameAndSurnameAndYearOfBirth("Omar",
                "Haiam", 1000).toString());

        System.out.println("Printing lines from db with year of birth 1985: ");
        final List<Author> birthAuthor = authorRepository.findAllByYearOfBirth(1985);
        for (Author author : birthAuthor) {
            System.out.print("Line №" + birthAuthor.indexOf(author) + ": ");
            System.out.println(author.toString());
        }

        System.out.println("Printing lines from db with citizenship: ");
        final List<Author> citizenshipAuthor = authorRepository.findAllByCitizenship("Soviet Republic");
        for (Author author : citizenshipAuthor) {
            System.out.print("Line №" + citizenshipAuthor.indexOf(author) + ": ");
            System.out.println(author.toString());
        }

        authorRepository.deleteAll();
    }
}
