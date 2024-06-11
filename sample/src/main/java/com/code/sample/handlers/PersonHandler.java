package com.code.sample.handlers;

import com.code.sample.models.PersonModel;
import com.code.sample.repository.PersonRepository;
import com.code.sample.repository.PersonRepositoryImp;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class PersonHandler {

    private static final Logger logger = LogManager.getLogger(PersonHandler.class);

    private final PersonRepositoryImp personRepositoryImp;

    // Simulating database call
    public Mono<ServerResponse> getPerson(ServerRequest request) {
        logger.info("Retrieving object of type person");
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(personRepositoryImp.getPerson()));
    }

    // Simulating database call to retrieve name
    public Mono<ServerResponse> getName(ServerRequest request) {
        logger.info("Retrieving name of person");
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(personRepositoryImp.getName()));
    }

    // Simulating database call to retrieve age
    public Mono<ServerResponse> getAge(ServerRequest request) {
        logger.info("Retrieving age of person");
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(personRepositoryImp.getAge()));
    }

    // Simulating database call to retrieve gender
    public Mono<ServerResponse> getGender(ServerRequest request) {
        logger.info("Retrieving gender of person");
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(personRepositoryImp.getGender()));
    }

    // Simulating database call to retrieve gender
    public Mono<ServerResponse> getPersons(ServerRequest request) {
        logger.info("Retrieving a list of persons");
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(personRepositoryImp.getAllPersons()));
    }

}
