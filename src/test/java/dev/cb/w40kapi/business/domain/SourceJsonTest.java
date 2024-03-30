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

import java.time.Year;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@JsonTest
public class SourceJsonTest {

    @Autowired
    private ObjectMapper objectMapper;

    private Source source;
    private String sourceJson;
    private Source[] sourceArray;
    private String sourceArrayJson;

    @BeforeEach
    public void setUp() {
        source = new Source(33, "Test", Year.of(2011));
        sourceJson = """
                {
                    "id": 33,
                    "title": "Test",
                    "publication": "2011"
                }
                """;
        sourceArray = Arrays.array(new Source(33, "Test", Year.of(2011)),
                new Source(5, "Rulebook", Year.of(1998)));
        sourceArrayJson = """
                [
                 {"id": 33, "title": "Test", "publication" : "2011"},   
                 {"id": 5, "title": "Rulebook", "publication" : "1998"}   
                ]
                """;
    }

    @Test
    public void sourceShouldSerialize() throws JsonProcessingException, JSONException {
        // given

        // when
        String result = this.objectMapper.writeValueAsString(source);

        // then
        JSONAssert.assertEquals(sourceJson, result, false);
    }

    @Test
    public void sourceJsonShouldDeserialize() throws JsonProcessingException {
        // given

        // when
        Source result = this.objectMapper.readValue(sourceJson, Source.class);

        // then
        assertThat(result).isEqualTo(source);
    }

    @Test
    public void sourceArrayShouldSerialize() throws JsonProcessingException, JSONException {
        // given

        // when
        String result = this.objectMapper.writeValueAsString(sourceArray);

        // then
        JSONAssert.assertEquals(sourceArrayJson, result, true);
    }

    @Test
    public void sourceArrayJsonShouldDeserialize() throws JsonProcessingException {
        // given

        // when
        Source[] result = this.objectMapper.readValue(sourceArrayJson, Source[].class);

        // then
        assertThat(result).isEqualTo(sourceArray);
    }
}
