package com.damienrubio.kata.tennis;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.models.Contact;
import io.swagger.models.Info;
import io.swagger.models.License;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by damien on 05/03/2017.
 */
@Configuration
//@EnableSwagger2
public class SwaggerConfig {

    @PostConstruct
    private void configureSwagger() {
        BeanConfig config = new BeanConfig();
        config.setConfigId(getClass().getPackage().getName());
        config.setTitle("Kata Tennis API");
        config.setDescription("API pour gérer un match de tennis");
        config.setContact("Damien Rubio");
        config.setInfo(apiInfo());
        config.setVersion("v1");
        config.setSchemes(new String[]{"http",
                                       "https"});
        config.setBasePath("/api");
        config.setResourcePackage(getClass().getPackage().getName());
        config.setPrettyPrint(true);
        config.setScan(true);
    }

    private Info apiInfo() {
        return new Info().title("Kata Tennis API").description("API pour gérer un match de tennis")
                         .contact(new Contact().name("Damien Rubio").url("https://github.com/damru/kata-tennis/").email("rubio.damien@gmail.com"))
                         .license(new License().name("Apache License Version 2.0").url("https://github.com/damru/kata-tennis/LICENSE"))
                         .version("1.0");
    }

    //    @Bean
    //    public Docket swaggerSettings() {
    //        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
    //                                                      .apis(RequestHandlerSelectors.basePackage(getClass().getPackage().getName()))
    //                                                      .paths(PathSelectors.any()).build();
    //    }
    //
    //    private ApiInfo apiInfo() {
    //        return new ApiInfoBuilder().title("Kata Tennis API").description("API pour gérer un match de tennis")
    //                                   .contact(new Contact("Damien Rubio", "https://github.com/damru/kata-tennis/", "rubio.damien@gmail.com"))
    //                                   .license("Apache License Version 2.0").licenseUrl("https://github.com/damru/kata-tennis/LICENSE")
    //                                   .version("1.0").build();
    //    }

}
