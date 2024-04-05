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
public class TitleJsonTest {

    @Autowired
    private ObjectMapper objectMapper;

    private Title title;
    private String titleJson;
    private Title[] titleArray;
    private String titleArrayJson;

    @BeforeEach
    public void setUp() {
        title = new Title(9, "Lord");
        titleJson = """
                {
                    "id": 9,
                    "name": "Lord"
                }
                """;
        titleArray = Arrays.array(
                new Title(9, "Lord"),
                new Title(11, "Dummy")
        );
        titleArrayJson = """
                [
                    {"id": 9, "name": "Lord"},
                    {"id": 11, "name": "Dummy"}
                ]
                """;
    }

    @Test
    public void titleShouldSerialize() throws JsonProcessingException, JSONException {
        // given

        // when
        String result = this.objectMapper.writeValueAsString(title);

        // then
        System.out.println(title);
        JSONAssert.assertEquals(titleJson, result, true);
    }

    @Test
    public void titleShouldDeserialize() throws JsonProcessingException {
        // given

        // when
        Title result = this.objectMapper.readValue(titleJson, Title.class);

        // then
        assertThat(result).isEqualTo(title);
    }

    @Test
    public void titleArrayShouldSerialize() throws JsonProcessingException, JSONException {
        // given

        // when
        String result = this.objectMapper.writeValueAsString(titleArray);

        // then
        JSONAssert.assertEquals(titleArrayJson, result, true);
    }

    @Test
    public void titleArrayShouldDeserialize() throws JsonProcessingException {
        // given

        // when
        Title[] result = this.objectMapper.readValue(titleArrayJson, Title[].class);

        // then
        assertThat(result).isEqualTo(titleArray);
    }
}