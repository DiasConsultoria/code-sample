package com.code.sample.webclients;

import com.code.sample.models.PersonModel;
import com.code.sample.routers.PersonRouter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class PersonWebClient {

    private final WebClient client;

    // Spring Boot autoconfigures a `WebClient.Builder` instance with nice defaults and customizations.
    // We can use it to create a dedicated `WebClient` for our component.
    public PersonWebClient(WebClient.Builder builder) {
        this.client = builder.baseUrl("http://localhost:8080").build();
    }


    public Mono<String> getPerson() {
        return this.client.get().uri("/api/v1/person").accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(PersonModel.class)
                .map(PersonModel::toString);
    }

    public Mono<String> getName() {
        return this.client.get().uri("/api/v1/person/name").accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(PersonModel.class)
                .map(PersonModel::getName);
    }

    public Mono<Integer> getAge() {
        return this.client.get().uri("/api/v1/person/age").accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(PersonModel.class)
                .map(PersonModel::getAge);
    }

    public Mono<String> getGender() {
        return this.client.get().uri("/api/v1/person/gender").accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(PersonModel.class)
                .map(PersonModel::getGender);
    }

    public Mono<String> getPersons() {
        return this.client.get().uri("/api/v1/person/persons").accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(PersonModel.class)
                .map(PersonModel::toString);
    }

}
