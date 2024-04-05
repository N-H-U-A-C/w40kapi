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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@JsonTest
public class ExcerptJsonTest {

    @Autowired
    private ObjectMapper objectMapper;

    private Excerpt excerpt;
    private String excerptJson;
    private Excerpt[] excerptArray;
    private String excerptArrayJson;

    @BeforeEach
    public void setUp() {
        excerpt = new Excerpt(3, "Title", "Content", "Context");
        excerptJson = """
                {
                    "id": 3,
                    "title" : "Title",
                    "content" : "Content",
                    "context": "Context",
                    "author": null
                }
                """;
        excerptArray = Arrays.array(
                new Excerpt(3, "Title", "Content", "Context"),
                new Excerpt(6, "This is a title", "This is a content", "This is a context"));
        excerptArrayJson = """
                [
                    {"id": 3, "title" : "Title", "content" : "Content", "context": "Context", "author": null},
                    {"id": 6, "title" : "This is a title", "content" : "This is a content", "context": "This is a context", "author": null}
                ]
                """;
    }

    @Test
    public void excerptShouldSerialize() throws JsonProcessingException, JSONException {
        // given

        // when
        String result = this.objectMapper.writeValueAsString(excerpt);

        // then
        JSONAssert.assertEquals(excerptJson, result, true);
    }

    @Test
    public void excerptShouldDeserialize() throws JsonProcessingException {
        // given

        // when
        Excerpt result = this.objectMapper.readValue(excerptJson, Excerpt.class);

        // then
        assertThat(result).isEqualTo(excerpt);
    }

    @Test
    public void excerptArrayShouldSerialize() throws JsonProcessingException, JSONException {
        // given

        // when
        String result = this.objectMapper.writeValueAsString(excerptArray);

        // then
        JSONAssert.assertEquals(excerptArrayJson, result, true);
    }

    @Test
    public void excerptArrayShouldDeserialize() throws JsonProcessingException {
        // given

        // when
        Excerpt[] result = this.objectMapper.readValue(excerptArrayJson, Excerpt[].class);

        // then
        assertThat(result).isEqualTo(excerptArray);
    }
}