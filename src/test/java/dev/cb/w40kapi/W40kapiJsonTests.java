package dev.cb.w40kapi;

import dev.cb.w40kapi.business.domain.Category;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
class W40kapiJsonTests {

    @Autowired
    private JacksonTester<Category> json;
    @Autowired
    private JacksonTester<Category[]> jsonArray;

    Category category = new Category(33, "Dummy");
    Category[] categoryArray = Arrays.array(new Category(55,"Test"),new Category(1,"Ok"));

    @Test
    void CategorySerializationTest() throws IOException {
        // testing equality
        assertThat(json.write(category)).isStrictlyEqualToJson("json/category.json");

        // testing json values
        assertThat(json.write(category)).hasJsonPathNumberValue("@.id");
        assertThat(json.write(category)).extractingJsonPathNumberValue("@.id").isEqualTo(33);
        assertThat(json.write(category)).hasJsonPathStringValue("@.name");
        assertThat(json.write(category)).extractingJsonPathStringValue("@.name").isEqualTo("Dummy");

    }

    @Test
    void CategoryDeserializationTest() throws IOException {
        String categoryJson = """
                {
                  "id": 33,
                  "name": "Dummy"
                }
                """;

        // testing equality
        assertThat(json.parse(categoryJson)).isEqualTo(category);

        // testing object values
        assertThat(json.parseObject(categoryJson).id()).isEqualTo(33);
        assertThat(json.parseObject(categoryJson).name()).isEqualTo("Dummy");
    }

    @Test
    void CategoryArraySerializationTest() throws IOException {
        // testing equality
        assertThat(jsonArray.write(categoryArray)).isStrictlyEqualToJson("json/category_array.json");
    }

    @Test
    void CategoryArrayDeserializationTest() throws IOException {
        String categoryArrayJson = """
                [
                  {"id":  55, "name": "Test"},
                  {"id":  1, "name": "Ok"}
                ]
                """;

        // testing equality
        assertThat(jsonArray.parse(categoryArrayJson)).isEqualTo(categoryArray);
    }
}
