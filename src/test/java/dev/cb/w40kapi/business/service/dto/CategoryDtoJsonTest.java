package dev.cb.w40kapi.business.service.dto;

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
public class CategoryDtoJsonTest {

    @Autowired
    private ObjectMapper objectMapper;

    private CategoryDto categoryDto;
    private String categoryDtoJson;
    private CategoryDto[] categoryDtoArray;
    private String categoryDtoArrayJson;

    @BeforeEach
    public void setUp() {
        categoryDto = new CategoryDto(33, "Dummy");
        categoryDtoJson = """
                {
                  "id": 33,
                  "name": "Dummy"
                }
                """;
        categoryDtoArray = Arrays.array(
                new CategoryDto(55, "Test"),
                new CategoryDto(1, "Ok"));
        categoryDtoArrayJson = """
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
        String result = this.objectMapper.writeValueAsString(categoryDto);

        // then
        JSONAssert.assertEquals(categoryDtoJson, result, true);
    }

    @Test
    public void categoryShouldDeserialize() throws JsonProcessingException {
        // given

        // when
        CategoryDto result = this.objectMapper.readValue(categoryDtoJson, CategoryDto.class);

        // then
        assertThat(result).isEqualTo(categoryDto);
    }

    @Test
    public void categoryArrayShouldSerialize() throws JsonProcessingException, JSONException {
        // given

        // when
        String result = this.objectMapper.writeValueAsString(categoryDtoArray);

        // then
        JSONAssert.assertEquals(categoryDtoArrayJson, result, true);
    }

    @Test
    public void categoryArrayShouldDeserialize() throws JsonProcessingException {
        // given

        // when
        CategoryDto[] result = this.objectMapper.readValue(categoryDtoArrayJson, CategoryDto[].class);

        // then
        assertThat(result).isEqualTo(categoryDtoArray);
    }
}