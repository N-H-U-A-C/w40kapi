package dev.cb.w40kapi.business.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@JsonTest
class AuthorJsonTest {

    @Autowired
    private ObjectMapper objectMapper;

    private Author author;
    private String authorJson;
    private Author[] authorArray;
    private String authorArrayJson;

    @BeforeEach
    void setUp() {
        author = new Author(5, "Chuck Palahniuk", List.of(new Title(9, "Lord")));
        authorJson = """
                {
                    "id": 5,
                    "name": "Chuck Palahniuk",
                    "titles": [
                      {
                        "id": 9,
                        "name": "Lord"
                      }
                    ]
                  }
                """;
        authorArray = Arrays.array(
                new Author(5, "Chuck Palahniuk", List.of(new Title(9, "Lord"))),
                new Author(55, "OK Cowboy"));
        authorArrayJson = """
                [
                    {"id": 5, "name": "Chuck Palahniuk", "titles": [{"id": 9, "name": "Lord"}]},
                    {"id": 55, "name" : "OK Cowboy", "titles": []}
                ]
                """;
    }

    @Test
    public void authorShouldSerialize() throws JsonProcessingException, JSONException {
        // given

        // when
        String result = this.objectMapper.writeValueAsString(author);

        // then
        JSONAssert.assertEquals(authorJson, result, true);
    }

    @Test
    public void authorShouldDeserialize() throws JsonProcessingException {
        // given

        // when
        Author result = this.objectMapper.readValue(authorJson, Author.class);

        // then
        assertThat(author).isEqualTo(result);
    }

    @Test
    public void authorArrayShouldSerialize() throws JsonProcessingException, JSONException {
        // given

        // when
        String result = this.objectMapper.writeValueAsString(authorArray);

        // then
        JSONAssert.assertEquals(authorArrayJson, result, true);
    }

    @Test
    public void authorArrayShouldDeserialize() throws JsonProcessingException {
        // given

        // when
        Author[] result = this.objectMapper.readValue(authorArrayJson, Author[].class);

        // then
        assertThat(result).isEqualTo(authorArray);
    }
}