/*
 * 
 */

package me.melvins.labs.configs;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * Configuration for Swagger Implementation.
 *
 * @author MelvinMathai
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    /**
     * <p>
     * Bean Definition for Swagger Docket Instance.
     * </p>
     * <p>
     * Disables default Response messages and adds a custom default message for {@code HttpStatus
     * .INTERNAL_SERVER_ERROR}.
     * </p>
     *
     * @return Swagger Docket Instance
     */
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .useDefaultResponseMessages(true)
                .globalResponseMessage(RequestMethod.GET,
                        Lists.newArrayList(
                                new ResponseMessageBuilder().code(INTERNAL_SERVER_ERROR.value()).message
                                        (INTERNAL_SERVER_ERROR.name())
                                        .responseModel(new ModelRef("ERROR")).build()));
    }

    /**
     * @return
     */
    private ApiKey apiKey() {
        return new ApiKey("mykey", "api_key", "header");
    }

}
