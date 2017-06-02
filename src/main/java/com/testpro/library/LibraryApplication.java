package com.testpro.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Maim method of application
 */
@SpringBootApplication
@EnableAutoConfiguration
public class LibraryApplication extends SpringBootServletInitializer {

    public static void main(final String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

}
