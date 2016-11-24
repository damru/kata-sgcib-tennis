package com.damru.kata.sgcib.tennis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by damien on 21/11/2016.
 */
@SpringBootApplication
@RestController
public class TennisApplication {

    @RequestMapping("/")
    public String home() {
        return "This is Kata Tennis !";
    }

    public static void main(String[] args) {
        SpringApplication.run(TennisApplication.class, args);
    }

}
