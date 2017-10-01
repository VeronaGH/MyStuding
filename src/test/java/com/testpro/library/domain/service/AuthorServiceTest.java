package com.testpro.library.domain.service;

import com.testpro.library.domain.model.Author;
import com.testpro.library.domain.mongodb.AuthorRepository;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by Pigas on 22.05.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService;

    private static List<Author> author = new ArrayList<Author>();

    @BeforeClass
    public static void setUp() {
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
    }

//    @Test
//    public void initTest() throws Exception {
//
//        doNothing().when(authorRepository).deleteAll();
//        doReturn(null).when(authorRepository).save(any(Author.class));
//        authorService.init();
//        verify(authorRepository, atLeastOnce()).deleteAll();
//        verify(authorRepository, atLeast(7)).save(any(Author.class));
//    }

    @Test
    public void checkTest() throws Exception {
        doReturn(author).when(authorRepository).findAll();
        doReturn(Arrays.asList(author.get(2), author.get(5))).when(authorRepository).findAllByName("David");
        doReturn(Arrays.asList(author.get(5), author.get(6))).when(authorRepository).findAllBySurname("Fresto");
        doReturn(author.get(4)).when(authorRepository).findOneByNameAndSurnameAndYearOfBirth("Omar",
                "Haiam", 1000);
        doReturn(Arrays.asList(author.get(3))).when(authorRepository).findAllByNameAndSurname("David",
                "Ferko");
        doReturn(author.get(3)).when(authorRepository).findOneById(3);
        doReturn(Arrays.asList(author.get(0), author.get(5))).when(authorRepository).findAllByYearOfBirth(1985);
        doReturn(Arrays.asList(author.get(3))).when(authorRepository).findAllByCitizenship("Soviet Republic");
        doNothing().when(authorRepository).deleteAll();
        assertEquals (author, authorService.findAuthor(new Author(
                0,
                null,
                null,
                0,
                null,
                null,
                true)));
        verify(authorRepository, atLeastOnce()).findAll();
    }
}
