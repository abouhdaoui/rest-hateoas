package com.example.resthateoas.runner;

import com.example.resthateoas.RestHateoasApplication;
import com.example.resthateoas.model.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by abouhdaoui on 12/06/2020
 */
@Component
public class RunnerCommand {

    private static final Logger log = LoggerFactory.getLogger(RestHateoasApplication.class);

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        // cet object de retour est le Bean
        return builder.build();
    }

    @Bean
    public CommandLineRunner runner(RestTemplate restTemplate) throws Exception{
        return args -> {
            Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
            log.info(quote.toString());
        };
    }
}
