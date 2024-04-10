package dev.cb.w40kapi.controller;

import dev.cb.w40kapi.business.domain.Excerpt;
import dev.cb.w40kapi.business.service.ExcerptService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebMvcTest(ExcerptController.class)
public class ExcerptControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ExcerptController classUnderTest;
    @MockBean
    private ExcerptService excerptService;
    private Integer id;
    private Optional<Excerpt> excerptOptional;

    @BeforeEach
    public void setUp() {
        id = Integer.valueOf(1);
    }

    @Test
    public void shouldCallGetByIdOfExcerptService() {
        // given
        excerptOptional = Optional.empty();
        when(excerptService.getById(id)).thenReturn(excerptOptional);

        // when
        classUnderTest.getById(id);

        // then
        verify(excerptService).getById(id);
    }

    @Test
    public void statusCodeShouldBe200() {
        // given
        excerptOptional = Optional.of(new Excerpt(3, "Title", "Content", "Context"));
        when(excerptService.getById(id)).thenReturn(excerptOptional);

        // when
        ResponseEntity<Excerpt> response = classUnderTest.getById(id);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void statusCodeShouldBe404() {
        // given
        excerptOptional = Optional.empty();
        when(excerptService.getById(id)).thenReturn(excerptOptional);

        // when
        ResponseEntity<Excerpt> response = classUnderTest.getById(id);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}