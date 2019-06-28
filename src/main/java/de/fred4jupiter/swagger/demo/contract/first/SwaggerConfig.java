package de.fred4jupiter.swagger.demo.contract.first;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Call swagger ui via: http://localhost:8080/swagger-ui.html
 */
@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .groupName("swagger-demo-contract-first")
                .select()
                .apis(RequestHandlerSelectors.basePackage("de.fred4jupiter.swagger.demo.contract.first.controller"))
//                .paths(PathSelectors.ant("/v1/**"))
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("swagger-demo-contract-first")
                .description("Spring Boot with Swagger using the contract-first paradigm.")
                .version("1.0.0")
                .build();
    }
}
