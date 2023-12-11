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
	void contextLoads() {
	}

	@Test
	void shouldReturnAllCategories() {
		ResponseEntity<String> response = restTemplate.getForEntity("/categories", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

		DocumentContext documentContext = JsonPath.parse(response.getBody());
		int count = documentContext.read("$.length()");
		assertThat(count).isEqualTo(2);

		JSONArray ids = documentContext.read("$..id");
		assertThat(ids).asList().containsExactlyInAnyOrder(1,2);

		JSONArray names = documentContext.read("$..name");
		assertThat(names).asList().containsExactlyInAnyOrder("Thought for the day","Military");
	}
}
