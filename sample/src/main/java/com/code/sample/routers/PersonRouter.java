package com.code.sample.routers;

import com.code.sample.handlers.PersonHandler;
import com.code.sample.repository.PersonRepositoryImp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class PersonRouter {

    private static final Logger logger = LogManager.getLogger(PersonRouter.class);

    @Bean
    public RouterFunction<ServerResponse> getPerson(PersonHandler personHandler) {
        logger.info("Route GET Person");
        return RouterFunctions
                .route(GET("/api/v1/person").and(accept(MediaType.APPLICATION_JSON)), personHandler::getPerson);
    }

    @Bean
    public RouterFunction<ServerResponse> getName(PersonHandler personHandler) {
        logger.info("Route GET name");
        return RouterFunctions
                .route(GET("/api/v1/person/name").and(accept(MediaType.APPLICATION_JSON)), personHandler::getName);
    }

    @Bean
    public RouterFunction<ServerResponse> getAge(PersonHandler personHandler) {
        logger.info("Route GET age");
        return RouterFunctions
                .route(GET("/api/v1/person/age").and(accept(MediaType.APPLICATION_JSON)), personHandler::getAge);
    }

    @Bean
    public RouterFunction<ServerResponse> getGender(PersonHandler personHandler) {
        logger.info("Route GET gender");
        return RouterFunctions
                .route(GET("/api/v1/person/age").and(accept(MediaType.APPLICATION_JSON)), personHandler::getGender);
    }

    @Bean
    public RouterFunction<ServerResponse> getPersons(PersonHandler personHandler) {
        logger.info("Route GET persons");
        return RouterFunctions
                .route(GET("/api/v1/person/persons").and(accept(MediaType.APPLICATION_JSON)), personHandler::getPersons);
    }
}
