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
                    {"id": 4, "name": "Boba Fett", "titles": []},
                    {"id": 3, "name": "Casimir", "titles": []},
                    {"id": 2, "name": "Inquisitor Czevak", "titles": []},
                    {"id": 1, "name": "Inquisitor Damarn", "titles": [{"id": 1, "name": "Ordo Malleus"}]},
                    {"id": 5, "name": "Victor Hugo", "titles": [{"id": 2, "name": "Lord Commander"}]}
                ]
                """;

        // when
        ResponseEntity<String> response = restTemplate.getForEntity("/authors", String.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        JSONAssert.assertEquals(expected, response.getBody(), true);
    }
}