/*
 * 
 */

package me.melvins.labs.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * Configuration for Swagger Implementation on this Web App.
 *
 * @author Mels
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
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET,
                        Lists.newArrayList(
                                new ResponseMessageBuilder()
                                        .code(INTERNAL_SERVER_ERROR.value())
                                        .message(INTERNAL_SERVER_ERROR.name())
                                        .responseModel(new ModelRef("ERROR"))
                                        .build()))
                .select()
                .build();
    }

    /**
     * Api Information.
     *
     * @return ApiInfo
     */
    private ApiInfo apiInfo() {
        return new ApiInfo("Skeleton Service", "Skeleton Java REST Service", "0.1",
                "Terms", "Mels", "Licenced To Mels", "Licence URL");
    }

}
