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
                    "id": 6,
                    "header": "This is a header test",
                    "content": "Dummy content",
                    "context": "This is a context test",
                    "author": {"id": 5, "name": "Victor Hugo",
                        "titles": [{"id": 2, "name": "Lord Commander"}]
                    },
                    "categories": [{"id": 1, "name": "Thought for the day"}],
                    "excerptSources": [{
                        "id": {"excerptId": 6, "sourceId": 5},
                        "page" : 99,
                        "source": {"id": 5, "name": "Dummy Book", "publication": "1950"}
                    }]
                }
                """;

        // when
        ResponseEntity<String> response = restTemplate.getForEntity("/excerpts/6", String.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        JSONAssert.assertEquals(expected, response.getBody(), true);
    }

    @Test
    public void shouldNotReturnExcerptByIdIfDoesNotExist() {
        // given

        // when
        ResponseEntity<String> response = restTemplate.getForEntity("/excerpts/10", String.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);

        assertThat(response.getBody()).isNull();
    }
}