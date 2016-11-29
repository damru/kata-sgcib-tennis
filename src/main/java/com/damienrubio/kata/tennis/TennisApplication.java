package com.damienrubio.kata.tennis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by damien on 21/11/2016.
 */
@SpringBootApplication
public class TennisApplication {

    @RequestMapping("/")
    public String home() {
        return "This is Kata Tennis !";
    }

    public static void main(String[] args) {
        SpringApplication.run(TennisApplication.class, args);
    }

}
