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
public class ExcerptSourceJsonTest {

    @Autowired
    private ObjectMapper objectMapper;

    private ExcerptSource excerptSource;
    private String excerptSourceJson;
    private ExcerptSource[] excerptSourceArray;
    private String excerptSourceArrayJson;

    @BeforeEach
    public void setUp() {
        excerptSource = new ExcerptSource(
                new ExcerptSource.ExcerptSourceId(3, 6),
                (short) 33,
                new Excerpt(3, "Title", "Content", "Context"),
                new Source(33, "Test", Year.of(2011)));
        excerptSourceJson = """
                {
                    "id": {
                        "excerptId": 3,
                        "sourceId": 6
                    },
                    "page": 33,
                    "excerpt": {
                        "id": 3,
                        "title": "Title",
                        "content": "Content",
                        "context": "Context",
                        "author": null,
                        "categories": []
                    },
                    "source": {
                        "id": 33,
                        "title": "Test",
                        "publication": "2011"
                    }
                }
                """;
        excerptSourceArray = Arrays.array(
                new ExcerptSource(
                        new ExcerptSource.ExcerptSourceId(3, 6),
                        (short) 33,
                        new Excerpt(3, "Title", "Content", "Context"),
                        new Source(33, "Test", Year.of(2011))),
                new ExcerptSource(
                        new ExcerptSource.ExcerptSourceId(4, 8),
                        (short) 50,
                        new Excerpt(6, "This is a title", "This is a content", "This is a context"),
                        new Source(5, "Rulebook", Year.of(1998))));
        excerptSourceArrayJson = """
                [
                    {"id": {"excerptId": 3, "sourceId": 6},
                    "page": 33,
                    "excerpt": {"id": 3, "title": "Title", "content": "Content", "context": "Context", "author": null, "categories": []},
                    "source": {"id": 33, "title": "Test", "publication": "2011"}
                    },
                    {"id": {"excerptId": 4, "sourceId": 8},
                    "page": 50,
                    "excerpt": {"id": 6, "title": "This is a title", "content": "This is a content", "context": "This is a context", "author": null, "categories": []},
                    "source": {"id": 5, "title": "Rulebook", "publication": "1998"}
                    }
                ]
                """;
    }

    @Test
    public void excerptSourceShouldSerialize() throws JsonProcessingException, JSONException {
        // given

        // when
        String result = this.objectMapper.writeValueAsString(excerptSource);

        // then
        JSONAssert.assertEquals(excerptSourceJson, result, true);
    }

    @Test
    public void excerptSourceShouldDeserialize() throws JsonProcessingException {
        // given

        // when
        ExcerptSource result = this.objectMapper.readValue(excerptSourceJson, ExcerptSource.class);

        // then
        assertThat(result).isEqualTo(excerptSource);
    }

    @Test
    public void excerptSourceArrayShouldSerialize() throws JsonProcessingException, JSONException {
        // given

        // when
        String result = this.objectMapper.writeValueAsString(excerptSourceArray);

        // then
        JSONAssert.assertEquals(excerptSourceArrayJson, result, true);
    }

    @Test
    public void excerptSourceArrayShouldDeserialize() throws JsonProcessingException {
        // given

        // when
        ExcerptSource[] result = this.objectMapper.readValue(excerptSourceArrayJson, ExcerptSource[].class);

        // then
        assertThat(result).isEqualTo(excerptSourceArray);
    }
}