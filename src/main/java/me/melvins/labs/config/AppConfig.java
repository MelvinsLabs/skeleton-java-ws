/*
 * 
 */

package me.melvins.labs.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Mels
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "me.melvins.labs")
@Import(value = SwaggerConfig.class)
public class AppConfig extends WebMvcConfigurerAdapter {

    /**
     * Overriding to add Resource Handlers.
     *
     * @param registry ResourceHandlerRegistry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/META-INF/resources/images/");
    }

}
