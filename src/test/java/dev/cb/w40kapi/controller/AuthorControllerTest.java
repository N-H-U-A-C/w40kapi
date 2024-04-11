package dev.cb.w40kapi.controller;

import dev.cb.w40kapi.business.domain.Author;
import dev.cb.w40kapi.business.service.AuthorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(AuthorController.class)
class AuthorControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private AuthorController classUnderTest;
    @MockBean
    private AuthorService authorService;
    private PageRequest defaultPageRequest;
    @Captor
    private ArgumentCaptor<PageRequest> captor;
    private Slice<Author> slice;

    @BeforeEach
    public void setUp() {
        defaultPageRequest = PageRequest.of(0, 20, Sort.by(Sort.Direction.ASC, "name"));
        slice = new PageImpl<>(List.of(
                new Author(5, "Chuck Palahniuk"),
                new Author(55, "OK Cowboy")));
    }

    @Test
    public void shouldCallGetAllOfAuthorService() {
        // given
        when(authorService.getAll(defaultPageRequest)).thenReturn(slice);

        // when
        classUnderTest.getAll(defaultPageRequest);

        // then
        verify(authorService).getAll(defaultPageRequest);
    }

    @Test
    public void pageRequestShouldBeFirstPageOf20AuthorsSortedByAscName() throws Exception {
        // given
        when(authorService.getAll(defaultPageRequest)).thenReturn(slice);

        // when
        mockMvc.perform(get("/authors"));

        // then
        verify(authorService).getAll(captor.capture());
        PageRequest usedPageRequest = captor.getValue();
        assertThat(usedPageRequest).isEqualTo(defaultPageRequest);
    }

    @Test
    public void pageRequestShouldBeSecondPageOfAuthors() throws Exception {
        // given
        PageRequest secondPage = PageRequest.of(1, 20, Sort.by(Sort.Direction.ASC, "name"));
        when(authorService.getAll(secondPage)).thenReturn(slice);

        // when
        mockMvc.perform(get("/authors?page=1"));

        // then
        verify(authorService).getAll(captor.capture());
        PageRequest usedPageRequest = captor.getValue();
        assertThat(usedPageRequest).isEqualTo(secondPage);
    }

    @Test
    public void pageRequestShouldBePageOf5Authors() throws Exception {
        // given
        PageRequest pageOfFiveAuthors = PageRequest.of(0, 5, Sort.by(Sort.Direction.ASC, "name"));
        when(authorService.getAll(pageOfFiveAuthors)).thenReturn(slice);

        // when
        mockMvc.perform(get("/authors?size=5"));

        // then
        verify(authorService).getAll(captor.capture());
        PageRequest usedPageRequest = captor.getValue();
        assertThat(usedPageRequest).isEqualTo(pageOfFiveAuthors);
    }

    @Test
    public void pageRequestShouldBePageOfAuthorsSortedByDescName() throws Exception {
        // given
        PageRequest pageSortedByDescName = PageRequest.of(0, 20, Sort.by(Sort.Direction.DESC, "name"));
        when(authorService.getAll(pageSortedByDescName)).thenReturn(slice);

        // when
        mockMvc.perform(get("/authors?sort=name,desc"));

        // then
        verify(authorService).getAll(captor.capture());
        PageRequest usedPageRequest = captor.getValue();
        assertThat(usedPageRequest).isEqualTo(pageSortedByDescName);
    }
}