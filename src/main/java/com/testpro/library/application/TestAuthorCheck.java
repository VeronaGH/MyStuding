package com.testpro.library.application;

import com.testpro.library.domain.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Pigas on 17.05.2017.
 */
@Controller
@RequestMapping("/test/check")
public class TestAuthorCheck {

    private final AuthorService authorService;

    public TestAuthorCheck(AuthorService authorService) {this.authorService = authorService;}


    @RequestMapping
    public void check(){
        authorService.check();
    }
}
