package com.testpro.library.domain.service;

import com.testpro.library.domain.model.Author;
import com.testpro.library.domain.mongodb.AuthorRepository;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * Created by Pigas on 22.05.2017.
 */
public class AuthorServiceInitTest {

    @Test
    public void initTest()throws Exception{
        List< Author> author = new ArrayList<Author>();
        author.add(new Author(2,"NNN", "SNM", 1985,"SWISE", "SGHDF", true));
        AuthorRepository authorRepository = mock(AuthorRepository.class);
        doNothing().when(authorRepository).deleteAll();
        doReturn(null).when(authorRepository).save(any(Author.class));
        AuthorService authorService = new AuthorService(authorRepository);
        authorService.init();
    }

    @Test
    public void checkTest() throws Exception {
        List< Author> author = new ArrayList<Author>();
        author.add(new Author(2,"NNN", "SNM", 1985,"SWISE", "SGHDF", true));
        AuthorRepository authorRepository = mock(AuthorRepository.class);
        doReturn(author).when(authorRepository).findAll();
        doReturn(author).when(authorRepository).findAllByName("NNN");
        doReturn(author).when(authorRepository).findAllBySurname("SNM");
        doReturn(author.get(0)).when(authorRepository).findByNameAndSurnameAndYearOfBirth("Omar",
                "Haiam", 1000);
        doReturn(author).when(authorRepository).findAllByYearOfBirth(1985);
        doReturn(author).when(authorRepository).findAllByCitizenship("SWIZE");
        doNothing().when(authorRepository).deleteAll();
        AuthorService authorService = new AuthorService(authorRepository);
        authorService.check();
    }
}
