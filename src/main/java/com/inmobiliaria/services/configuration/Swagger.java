package com.inmobiliaria.services.configuration;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .apiInfo(apiInfo())
          .securityContexts(Arrays.asList(securityContext()))
          .securitySchemes(Arrays.asList(apiKey()))
          .select()
          .apis(RequestHandlerSelectors.any())
          .paths(PathSelectors.any())
          .build();
    }
    private SecurityContext securityContext() { 
        return SecurityContext.builder().securityReferences(defaultAuth()).build(); 
    } 
    
    private ApiKey apiKey() { 
        return new ApiKey("JWT", "Authorization", "header"); 
    }
    private List<SecurityReference> defaultAuth() { 
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything"); 
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1]; 
        authorizationScopes[0] = authorizationScope; 
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes)); 
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API REST services")
                .description("Especificacion de REST API services")
                .termsOfServiceUrl("Terminos de Servicio")
                .license("Inmobiliaria")
                .version("1.0")
                .build();
    }
    /*
	   @Bean
	    public Docket infoApiAvailabilityHub() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .groupName("services")
	                .apiInfo(apiInfo())
	                .select()
	                .paths(regex("/v1.*"))
	                .build()
	                .useDefaultResponseMessages(false);
	    }


	    
	    @Bean
	    public Docket authenticationApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .groupName("OAuth 2.0 API")
	                .select()
	                .apis(RequestHandlerSelectors.any())
	                .paths(OAUTH_API)
	                .build();
	    }
	    
	    @Bean
	    public Docket companyApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .groupName("Company API")
	                .apiInfo(apiInfo())
	                .select()
	                .apis(RequestHandlerSelectors.any())
	                .paths(COMPANY_API)
	                .build()
	                .securitySchemes(Lists.newArrayList(securityScheme))
	                .securityContexts(Lists.newArrayList(securityContext));
	    }
	    */
}
