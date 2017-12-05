package com.testpro.library.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Jackson configuration file
 */
@Configuration
public class JacksonConfig extends WebMvcConfigurerAdapter{

    @Bean
    public ObjectMapper objectMapper() {
        final Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder = new Jackson2ObjectMapperBuilder();

        return jackson2ObjectMapperBuilder.createXmlMapper(false).build();
    }

}
