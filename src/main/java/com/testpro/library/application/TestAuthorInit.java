package com.testpro.library.application;

import com.testpro.library.domain.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Application for testing AuthorRepository, fulfilling repository "Author" with
 * test entity using method init of AuthorRepository class
 */
@Controller
@RequestMapping("/library/v1/init")
public class TestAuthorInit {

    private final AuthorService authorService;

    @Autowired
    public TestAuthorInit(final AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public void init() {
        System.out.println("Init method started...");
        authorService.init();
    }
}
