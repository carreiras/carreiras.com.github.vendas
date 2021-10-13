package com.diretoaocodigo.vendas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_12)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.diretoaocodigo.vendas.rest.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Vendas API")
                .description("Exemplo de microserviço de vendas com " +
                        "JPA, " +
                        "Spring Security, " +
                        "Autenticação JWT, " +
                        "Documentação Swagger, " +
                        "Bancos de dados H2 e MySQL.")
                .version("0.0.1-SNAPSHOT")
                .contact(contact())
                .build();
    }

    private Contact contact() {
        return new Contact("Ewerton L Carreira",
                "https://github.com/carreiras/",
                "ewertoncarreira@gmail.com");
    }
}