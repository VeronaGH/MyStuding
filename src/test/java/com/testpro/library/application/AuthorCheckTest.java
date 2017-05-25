package com.testpro.library.application;

import com.testpro.library.domain.service.AuthorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.doNothing;

/**
 * Created by Pigas on 25.05.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class AuthorCheckTest {

    @Mock
    AuthorService authorService;

    @InjectMocks
    TestAuthorCheck testAuthorCheck;

    @Test
    public void testCheck() {
        doNothing().when(authorService).check();
        testAuthorCheck.check();
    }
}
