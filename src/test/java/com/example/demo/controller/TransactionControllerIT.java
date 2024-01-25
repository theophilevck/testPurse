package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import org.testcontainers.shaded.org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class TransactionControllerIT {

    @Autowired
    private WebTestClient webTestClient;

    private String readJsonFile(String fileName) {
        try {
            File file = new File("src/test/resources/response/" + fileName);
            return FileUtils.readFileToString(file, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
            return "{}";
        }
    }

    @Test
    public void orderTest() {
        testCreateFirstTransaction();
        tryUpdateFirstTransactionWithCapture();
        updateFirstTransactionAuthorised();
        updateFirstTransactionCaptured();
        tryUpdateOrderLineFirstTransactionCapture();
        testCreateSecondTransaction();
        testRetrieveAllTransaction();
    }

    public void testCreateFirstTransaction() {
        webTestClient.post().uri("/Transaction/save")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromResource(new ClassPathResource("request/saveFirstTransaction.json")))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .json(readJsonFile("saveFirstTransaction.json"));
    }


    public void tryUpdateFirstTransactionWithCapture() {
        webTestClient.post().uri("/Transaction/update")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromResource(new ClassPathResource("request/tryUpdateToCaptureInProgressTransaction.json")))
                .exchange()
                .expectStatus().is5xxServerError();

    }


    public void updateFirstTransactionAuthorised() {
        webTestClient.post().uri("/Transaction/update")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromResource(new ClassPathResource("request/updateFirstTransactionAutorised.json")))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .json(readJsonFile("updateFirstTransactionAutorised.json"));

    }


    public void updateFirstTransactionCaptured() {
        webTestClient.post().uri("/Transaction/update")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromResource(new ClassPathResource("request/updateFirstTransactionCapture.json")))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .json(readJsonFile("updateFirstTransactionCapture.json"));

    }


    public void tryUpdateOrderLineFirstTransactionCapture() {
        webTestClient.post().uri("/Transaction/update")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromResource(new ClassPathResource("request/tryUpdateOrderOfCaptureTransaction.json")))
                .exchange()
                .expectStatus().is5xxServerError();

    }


    public void testCreateSecondTransaction() {
        webTestClient.post().uri("/Transaction/save")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromResource(new ClassPathResource("request/saveSecondTransaction.json")))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .json(readJsonFile("saveSecondTransaction.json"));
    }

    public void testRetrieveAllTransaction() {
        webTestClient.get().uri("/Transaction/retrieveAll")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .json(readJsonFile("retrieveAllTransaction.json"));
    }
}