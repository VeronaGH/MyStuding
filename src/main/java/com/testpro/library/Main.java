package com.testpro.library;

import org.springframework.boot.*;
        import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class Main {

    @RequestMapping("/")
    String home(String[] args) {
        return "Привет мир))";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
    }

}