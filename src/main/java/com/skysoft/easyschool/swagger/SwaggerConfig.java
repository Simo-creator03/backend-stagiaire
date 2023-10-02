package com.skysoft.easyschool.swagger;

import com.fasterxml.classmate.TypeResolver;
import com.skysoft.easyschool.config.ApplicationProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.schema.TypeNameExtractor;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Springfox Swagger configuration.
 *
 * Warning! When having a lot of REST endpoints, Springfox can become a performance issue. In that case, you can use a
 * specific Spring profile for this class, so that only front-end developers have access to the Swagger view.
 */
@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig implements WebMvcConfigurer {

    private final ApplicationProperties.Swagger properties;

    public SwaggerConfig(ApplicationProperties applicationProperties) {
        this.properties = applicationProperties.getSwagger();
    }

    @Bean
    public Docket swaggerSpringfoxApiDocket() {
        StopWatch watch = new StopWatch();
        watch.start();
        Contact contact = new Contact(
                properties.getContactName(),
                properties.getContactUrl(),
                properties.getContactEmail()
        );

        ApiInfo apiInfo = new ApiInfo(
                properties.getTitle(),
                properties.getDescription(),
                properties.getVersion(),
                properties.getTermsOfServiceUrl(),
                contact,
                properties.getLicense(),
                properties.getLicenseUrl(),
                new ArrayList<>());

        Docket docket = createDocket()
                .apiInfo(apiInfo)
                .select()
                .paths(regex(properties.getDefaultIncludePattern()))
                .build();
        watch.stop();
        return docket;

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "swagger-ui.html");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    protected Docket createDocket() {
        return new Docket(DocumentationType.SWAGGER_2);
    }
}
