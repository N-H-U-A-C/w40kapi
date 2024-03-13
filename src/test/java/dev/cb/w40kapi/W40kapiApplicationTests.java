package dev.cb.w40kapi;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class W40kapiApplicationTests {

	@Autowired
	TestRestTemplate restTemplate;

	@Test
	void shouldReturnFirstSortedPageOf20CategoriesIfNoParameter() {
		ResponseEntity<String> response = restTemplate.getForEntity("/categories", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

		DocumentContext documentContext = JsonPath.parse(response.getBody());
		JSONArray page = documentContext.read("$[*]");
		assertThat(page.size()).isEqualTo(20);

		JSONArray ids = documentContext.read("$..id");
		assertThat(ids).asList().containsExactly(10,11,12,13,14,15,16,17,18,19,20,21,3,4,5,6,7,8,9,2);

		JSONArray names = documentContext.read("$..name");
		assertThat(names).asList().containsExactly("10th","11th","12th","13th","14th","15th","16th","17th","18th","19th",
				"20th","21th","3rd","4th","5th","6th","7th","8th","9th","Military");
	}

	@Test
	void shouldReturnSecondPageOfCategories() {
		ResponseEntity<String> response = restTemplate.getForEntity("/categories?page=1", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

		DocumentContext documentContext = JsonPath.parse(response.getBody());
		JSONArray page = documentContext.read("$[*]");
		assertThat(page.size()).isEqualTo(1);

		JSONArray ids = documentContext.read("$..id");
		assertThat(ids).asList().containsExactly(1);

		JSONArray names = documentContext.read("$..name");
		assertThat(names).asList().containsExactly("Thought for the day");
	}

	@Test
	void shouldReturnPageOf1Category() {
		ResponseEntity<String> response = restTemplate.getForEntity("/categories?size=1", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

		DocumentContext documentContext = JsonPath.parse(response.getBody());
		JSONArray page = documentContext.read("$[*]");
		assertThat(page.size()).isEqualTo(1);

		JSONArray ids = documentContext.read("$..id");
		assertThat(ids).asList().containsExactly(10);

		JSONArray names = documentContext.read("$..name");
		assertThat(names).asList().containsExactly("10th");
	}

	@Test
	void shouldReturnPageOfCategoriesSortedById() {
		ResponseEntity<String> response = restTemplate.getForEntity("/categories?sort=id", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

		DocumentContext documentContext = JsonPath.parse(response.getBody());
		JSONArray page = documentContext.read("$[*]");
		assertThat(page.size()).isEqualTo(20);

		JSONArray ids = documentContext.read("$..id");
		assertThat(ids).asList().containsExactly(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);

		JSONArray names = documentContext.read("$..name");
		assertThat(names).asList().containsExactly("Thought for the day","Military","3rd","4th","5th","6th","7th","8th","9th","10th","11th","12th","13th","14th","15th","16th","17th","18th","19th","20th");
	}
}
