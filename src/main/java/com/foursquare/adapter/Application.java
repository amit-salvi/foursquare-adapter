package com.foursquare.adapter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Main class of the application
 */
@SpringBootApplication
//@PropertySource("classpath:application-DEV.properties")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
