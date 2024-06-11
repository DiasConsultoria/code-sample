package com.code.sample.routers;


import com.code.sample.models.PersonModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

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
                    assertThat(personModel.getName()).isEqualTo("Tiago");
                    assertThat(personModel.getAge()).isEqualTo(20);
                    assertThat(personModel.getGender()).isEqualTo("M");
                    assertThat(personModel.getAddress()).isEqualTo("SHIS Qi 27");
                    assertThat(personModel.getPhone()).isEqualTo("6199999999");
                });
    }
}