package com.testpro.library.application;

import com.testpro.library.domain.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Pigas on 17.05.2017.
 */
@Controller
@RequestMapping("/test/init")
public class TestAuthorInit {

    private final AuthorService authorService;

    @Autowired
    public TestAuthorInit(final AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping
    public void init(){
        authorService.init();
    }
}
