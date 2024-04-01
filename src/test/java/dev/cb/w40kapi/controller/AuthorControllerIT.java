package dev.cb.w40kapi.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthorControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldReturnFirstPageOf20AuthorsSortedByAscName() throws JSONException {
        // given
        String expected = """
                [
                    {"id": 4, "name": "Boba Fett"},
                    {"id": 3, "name": "Casimir"},
                    {"id": 2, "name": "Inquisitor Czevak"},
                    {"id": 1, "name": "Inquisitor Damarn"},
                    {"id": 5, "name": "Victor Hugo"}
                ]
                """;

        // when
        ResponseEntity<String> response = restTemplate.getForEntity("/authors", String.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        JSONAssert.assertEquals(expected, response.getBody(), true);
    }
}