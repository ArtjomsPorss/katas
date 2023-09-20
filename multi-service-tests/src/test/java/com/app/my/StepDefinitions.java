package com.app.my;

import io.cucumber.java8.En;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions implements En {

    private static final String FRONTEND_URL = "http://127.0.0.1:8082/front";
    private static final String RESPONSE = "response";
    private static final HashMap<String, Object> session = new HashMap<>();

    private static final RestTemplate template = new RestTemplate();

    public StepDefinitions() {
        Given("fist step", () -> {
            assertEquals(true, true);
        });

        Given("I call frontend {string} endpoint", (String endpointName) -> {
            String url = String.format("%s/%s", FRONTEND_URL, endpointName);
            ResponseEntity<String> response = getResponse(url);
            assertEquals(HttpStatus.OK, response.getStatusCode());
            session.put(RESPONSE, response);
        });

        Given("I receive the {string} response", (String expected) -> {
            String actual = ((ResponseEntity) session.get(RESPONSE)).getBody().toString();
            assertEquals(expected, actual);
        });
    }

    private ResponseEntity<String> getResponse(String endpointName) {
        return template.getForEntity(endpointName, String.class);
    }
}