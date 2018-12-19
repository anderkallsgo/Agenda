package br.com.omega.omega.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.omega.omega.resources"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("API Agenda",
                "Serviço responsável pela integração com front-end de Agenda Consultório.",
                "Documentação v1.0",
                null,
                new Contact("Anderson de Figueiró", "", "andersonkall@gmail.com"),
                null,
                null,
                Collections.emptyList());
    }
}
