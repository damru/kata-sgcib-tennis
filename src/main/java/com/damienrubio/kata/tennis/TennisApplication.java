package com.damienrubio.kata.tennis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

/**
 * Created by damien on 21/11/2016.
 */
@SpringBootApplication
//@EnableSwagger2
public class TennisApplication {

    public static void main(String[] args) {
        SpringApplication.run(TennisApplication.class, args);
    }

//    @Bean
//    public Docket swaggerSpringMvcPlugin() {
//        return new Docket(DocumentationType.SWAGGER_2)
//            .useDefaultResponseMessages(false)
//            .apiInfo(apiInfo())
//            .select()
//            .paths(Predicates.not(PathSelectors.regex("/error.*")))
//            .build();
//    }
//
//    @Component
//    @Primary
//    public class CustomObjectMapper extends ObjectMapper {
//        public CustomObjectMapper() {
//            setSerializationInclusion(JsonInclude.Include.NON_NULL);
//            configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//            configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//            configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//            enable(SerializationFeature.INDENT_OUTPUT);
//        }
//    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Kata Tennis")
            .description("API pour gérer un match de tennis")
            .contact(new Contact("Damien Rubio", "https://github.com/damru/kata-tennis/", "rubio.damien@gmail.com"))
            .license("Apache License Version 2.0")
            .licenseUrl("https://github.com/damru/kata-tennis/LICENSE")
            .version("1.0")
            .build();
    }

}
