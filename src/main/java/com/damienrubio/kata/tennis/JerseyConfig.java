package com.damienrubio.kata.tennis;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by damien on 04/03/2017.
 */
@Configuration
public class JerseyConfig extends ResourceConfig {

    @PostConstruct
    public void init() {
        packages(getClass().getPackage().getName() + ".resource");
    }

}
