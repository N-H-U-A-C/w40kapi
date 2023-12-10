package dev.cb.w40kapi;

import dev.cb.w40kapi.business.domain.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
class W40kapiJsonTest {

    @Autowired
    private JacksonTester<Category> json;

    @Test
    void CategorySerializationTest() throws IOException {
        var category = new Category(33, "Dummy");

        // testing equality
        assertThat(json.write(category)).isStrictlyEqualToJson("expected_category.json");

        // testing json values
        assertThat(json.write(category)).hasJsonPathNumberValue("@.id");
        assertThat(json.write(category)).extractingJsonPathNumberValue("@.id").isEqualTo(33);
        assertThat(json.write(category)).hasJsonPathStringValue("@.name");
        assertThat(json.write(category)).extractingJsonPathStringValue("@.name").isEqualTo("Dummy");

    }

    @Test
    void CategoryDeserializationTest() throws IOException {
        String expectedCategory = """
                {
                  "id": 33,
                  "name": "Dummy"
                }
                """;

        // testing equality
        assertThat(json.parse(expectedCategory)).isEqualTo(new Category(33, "Dummy"));

        // testing object values
        assertThat(json.parseObject(expectedCategory).id()).isEqualTo(33);
        assertThat(json.parseObject(expectedCategory).name()).isEqualTo("Dummy");
    }


}
