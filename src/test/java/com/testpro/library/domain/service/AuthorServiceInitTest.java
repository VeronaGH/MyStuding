package com.testpro.library.domain.service;

import com.testpro.library.domain.model.Author;
import com.testpro.library.domain.mongodb.AuthorRepository;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by Pigas on 22.05.2017.
 */
public class AuthorServiceInitTest {

    @Test
    public void initTest() throws Exception {
        AuthorRepository authorRepository = mock(AuthorRepository.class);
        doNothing().when(authorRepository).deleteAll();
        doReturn(null).when(authorRepository).save(any(Author.class));
        AuthorService authorService = new AuthorService(authorRepository);
        authorService.init();
    }

    @Test
    public void checkTest() throws Exception {
        List<Author> author = new ArrayList<Author>();
        author.add(new Author(1,
                "Paul",
                "Jenkins",
                1985,
                "United States of America",
                "Long, long, long story with happy end...",
                true));

        author.add(new Author(2,
                "Luke",
                "Mirigam",
                1961,
                "United States of America",
                "Long, long, long story without pappy end...",
                false));

        author.add(new Author(3,
                "David",
                "Ferko",
                1955,
                "United Kingdom of Grate Britain",
                "Middle hand novel autor.",
                false));

        author.add(new Author(4,
                "Mihail",
                "Veller",
                1967,
                "Soviet Republic",
                "Genius author of soviet prose",
                true));

        author.add(new Author(5,
                "Omar",
                "Haiam",
                1000,
                "Arabian East",
                "Genius ancient Arabic author",
                false));

        author.add(new Author(6,
                "David",
                "Fresto",
                1985,
                "New Zeland",
                "Quiet boy from a remote province",
                true));

        author.add(new Author(7,
                "Mishel",
                "Fresto",
                1980,
                "New Zeland",
                "A brother of a quiet boy from a remote province",
                true));

        AuthorRepository authorRepository = mock(AuthorRepository.class);
        doReturn(author).when(authorRepository).findAll();
        doReturn(author.subList(2, 3)).when(authorRepository).findAllByName("David");
        doReturn(author.subList(5, 7)).when(authorRepository).findAllBySurname("Fresto");
        doReturn(author.get(4)).when(authorRepository).findByNameAndSurnameAndYearOfBirth("Omar",
                "Haiam", 1000);
        doReturn(author.subList(5, 6)).when(authorRepository).findAllByYearOfBirth(1985);
        doReturn(author.subList(3, 4)).when(authorRepository).findAllByCitizenship("Soviet Republic");
        doNothing().when(authorRepository).deleteAll();
        AuthorService authorService = new AuthorService(authorRepository);
        authorService.check();
    }
}
