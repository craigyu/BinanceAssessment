package com.example.restbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class RestBackendApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(RestBackendApplication.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "5000"));
        app.run(args);
    }

}
