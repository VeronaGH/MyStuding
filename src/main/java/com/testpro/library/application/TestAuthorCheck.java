package com.testpro.library.application;

import com.testpro.library.domain.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Application for testing AuthorRepository, checking finished repository using
 * method check of AuthorRepository class
 */
@Controller
@RequestMapping("/library/v1/check")
public class TestAuthorCheck {

    private final AuthorService authorService;

    @Autowired
    public TestAuthorCheck(final AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public void check() {
        authorService.check();
    }
}
