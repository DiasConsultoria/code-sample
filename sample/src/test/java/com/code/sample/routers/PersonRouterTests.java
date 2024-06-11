package com.code.sample.routers;


import com.code.sample.models.PersonModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
//  We create a `@SpringBootTest`, starting an actual server on a `RANDOM_PORT`
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonRouterTests {

    // Spring Boot will create a `WebTestClient` for you,
    // already configure and ready to issue requests against "localhost:RANDOM_PORT"
    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testGetPerson() {
        webTestClient
                // Create a GET request to test an endpoint
                .get().uri("/api/v1/person")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                // and use the dedicated DSL to test assertions against the response
                .expectStatus().isOk()
                .expectBody(PersonModel.class).value(personModel -> {
                    assertThat(personModel.getName()).isNotEmpty();
                    assertThat(personModel.getName()).isEqualTo("Tiago");
                    assertThat(personModel.getAge()).isNotZero();
                    assertThat(personModel.getAge()).isEqualTo(20);
                    assertThat(personModel.getGender()).isNotEmpty();
                    assertThat(personModel.getGender()).isEqualTo("M");
                    assertThat(personModel.getAddress()).isNotEmpty();
                    assertThat(personModel.getAddress()).isEqualTo("SHIS Qi 27");
                    assertThat(personModel.getPhone()).isNotEmpty();
                    assertThat(personModel.getPhone()).isEqualTo("6199999999");
                });
    }

    @Test
    public void testGetName(){
        webTestClient
                .get().uri("/api/v1/person/name")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).value(name -> {
                    assertThat(name).isNotEmpty();
                    assertThat(name).isEqualTo("Tiago");
                });
    }

    @Test
    public void testGetAge(){
        webTestClient
                .get().uri("/api/v1/person/age")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Integer.class).value(age -> {
                    assertThat(age).isNotZero();
                    assertThat(age).isEqualTo(20);
                });
    }

    @Test
    public void testGetGender(){
        webTestClient
                .get().uri("/api/v1/person/gender")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).value(gender -> {
                    assertThat(gender).isNotEmpty();
                    assertThat(gender).isEqualTo("M");
                });
    }

    @Test
    public void testGetPersons(){
        webTestClient
                .get().uri("/api/v1/person/persons")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(PersonModel[].class).value(personModels -> {
                    assertThat(personModels).isNotEmpty();
                    assertThat(personModels[0].getName()).isEqualTo("Tiago");
                });
    }
}