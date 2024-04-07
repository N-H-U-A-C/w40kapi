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
public class ExcerptControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldReturnExcerptByIdIfExists() throws JSONException {
        // given
        String expected = """
                {
                    "id": 3,
                    "title": null,
                    "content": "There is a terrible darkness descending upon the galaxy, and we shall not see it end in our lifetimes.",
                    "context": "at the Conclave of Har",
                    "author": {
                        "id": 2,
                        "name": "Inquisitor Czevak"
                    }
                }
                """;

        // when
        ResponseEntity<String> response = restTemplate.getForEntity("/excerpts/3", String.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void shouldNotReturnExcerptByIdIfDoesntExist() {
        // given

        // when
        ResponseEntity<String> response = restTemplate.getForEntity("/excerpts/10", String.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);

        assertThat(response.getBody()).isNull();
    }
}