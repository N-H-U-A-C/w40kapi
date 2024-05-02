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

import java.time.Year;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@JsonTest
public class SourceDtoJsonTest {

    @Autowired
    private ObjectMapper objectMapper;

    private SourceDto sourceDto;
    private String sourceDtoJson;
    private SourceDto[] sourceDtoArray;
    private String sourceDtoArrayJson;

    @BeforeEach
    public void setUp() {
        sourceDto = new SourceDto(33, "Test", Year.of(2011));
        sourceDtoJson = """
                {
                  "id": 33,
                  "name": "Test",
                  "publication": "2011"
                }
                """;
        sourceDtoArray = Arrays.array(
                new SourceDto(33, "Test", Year.of(2011)),
                new SourceDto(5, "Rulebook", Year.of(1998)));
        sourceDtoArrayJson = """
                [
                 {"id": 33, "name": "Test", "publication" : "2011"},   
                 {"id": 5, "name": "Rulebook", "publication" : "1998"}   
                ]
                """;
    }

    @Test
    public void sourceDtoShouldSerialize() throws JsonProcessingException, JSONException {
        // given

        // when
        String result = this.objectMapper.writeValueAsString(sourceDto);

        // then
        JSONAssert.assertEquals(sourceDtoJson, result, true);
    }

    @Test
    public void sourceDtoShouldDeserialize() throws JsonProcessingException {
        // given

        // when
        SourceDto result = this.objectMapper.readValue(sourceDtoJson, SourceDto.class);

        // then
        assertThat(result).isEqualTo(sourceDto);
    }

    @Test
    public void sourceDtoArrayShouldSerialize() throws JsonProcessingException, JSONException {
        // given

        // when
        String result = this.objectMapper.writeValueAsString(sourceDtoArray);

        // then
        JSONAssert.assertEquals(sourceDtoArrayJson, result, true);
    }

    @Test
    public void sourceDtoArrayShouldDeserialize() throws JsonProcessingException {
        // given

        // when
        SourceDto[] result = this.objectMapper.readValue(sourceDtoArrayJson, SourceDto[].class);

        // then
        assertThat(result).isEqualTo(sourceDtoArray);
    }
}