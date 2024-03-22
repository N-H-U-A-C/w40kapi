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

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
class CategoryJsonTest {

    @Autowired
    private ObjectMapper objectMapper;

    private Category category;
    private String categoryJson;
    private Category[] categoryArray;
    private String categoryArrayJson;

    @BeforeEach
    public void setUp() {
        category = new Category(33, "Dummy");
        categoryJson = """
                {
                  "id": 33,
                  "name": "Dummy"
                }
                """;
        categoryArray = Arrays.array(new Category(55, "Test"),
                new Category(1, "Ok"));
        categoryArrayJson = """
                [
                  {"id": 55, "name": "Test"},
                  {"id": 1, "name": "Ok"}
                ]
                """;
    }

    @Test
    public void categoryShouldSerialize() throws JsonProcessingException, JSONException {
        // given

        // when
        String result = this.objectMapper.writeValueAsString(category);

        // then
        JSONAssert.assertEquals(categoryJson, result, false);
    }

    @Test
    public void categoryShouldDeserialize() throws JsonProcessingException {
        // given

        // when
        Category result = this.objectMapper.readValue(categoryJson, Category.class);

        // then
        assertThat(result).isEqualTo(category);
    }

    @Test
    public void categoryArrayShouldSerialize() throws JsonProcessingException, JSONException {
        // given

        // when
        String result = this.objectMapper.writeValueAsString(categoryArray);

        // then
        JSONAssert.assertEquals(categoryArrayJson, result, true);
    }

    @Test
    public void categoryArrayShouldDeserialize() throws JsonProcessingException {
        // given

        // when
        Category[] result = this.objectMapper.readValue(categoryArrayJson, Category[].class);

        // then
        assertThat(result).isEqualTo(categoryArray);
    }
}
