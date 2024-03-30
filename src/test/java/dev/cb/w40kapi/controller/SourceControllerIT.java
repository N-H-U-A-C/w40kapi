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
class SourceControllerIT {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void shouldReturnFirstPageofSourcesSortedByAscTitle() throws JSONException {
        // given
        String expected = """
                [
                    {"id": 4, "title": "Codex", "publication": "1998"},
                    {"id": 5, "title": "Dummy Book", "publication": "1950"},
                    {"id": 1, "title": "Rulebook (3rd Ed.)", "publication": "1998"},
                    {"id": 2, "title": "Rulebook (4th Ed.)", "publication": "2004"},
                    {"id": 3, "title": "Rulebook (5th Ed.)", "publication": "2008"}
                ]
                """;

        // when
        ResponseEntity<String> response = restTemplate.getForEntity("/sources", String.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        JSONAssert.assertEquals(expected, response.getBody(), true);
    }
}