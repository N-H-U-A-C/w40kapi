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
class CategoryControllerIT {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void shouldReturnFirstSliceOf20CategoriesSortedByAscName() throws JSONException {
        // given
        String expected = """
                [
                  {"id": 10, "name": "10th"},
                  {"id": 11, "name": "11th"},
                  {"id": 12, "name": "12th"},
                  {"id": 13, "name": "13th"},
                  {"id": 14, "name": "14th"},
                  {"id": 15, "name": "15th"},
                  {"id": 16, "name": "16th"},
                  {"id": 17, "name": "17th"},
                  {"id": 18, "name": "18th"},
                  {"id": 19, "name": "19th"},
                  {"id": 20, "name": "20th"},
                  {"id": 21, "name": "21th"},
                  {"id": 3, "name": "3rd"},
                  {"id": 4, "name": "4th"},
                  {"id": 5, "name": "5th"},
                  {"id": 6, "name": "6th"},
                  {"id": 7, "name": "7th"},
                  {"id": 8, "name": "8th"},
                  {"id": 9, "name": "9th"},
                  {"id": 2, "name": "Military"}
                ]
                """;

        // when
        ResponseEntity<String> response = restTemplate.getForEntity("/categories", String.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        JSONAssert.assertEquals(expected, response.getBody(), true);
    }
}