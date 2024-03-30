package dev.cb.w40kapi.controller;

import dev.cb.w40kapi.business.domain.Source;
import dev.cb.w40kapi.business.service.SourceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Year;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(SourceController.class)
class SourceControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private SourceController classUnderTest;
    @MockBean
    private SourceService sourceService;
    private PageRequest defaultPageRequest;
    @Captor
    private ArgumentCaptor<PageRequest> captor;
    private Page<Source> page;

    @BeforeEach
    public void setUp() {
        defaultPageRequest = PageRequest.of(0, 20, Sort.by(Sort.Direction.ASC, "title"));
        page = new PageImpl<>(List.of(
                new Source(33, "Test", Year.of(2011)),
                new Source(5, "Rulebook", Year.of(1998))));
    }

    @Test
    public void shouldCallGetAllOfSourceService() {
        // given
        when(sourceService.getAll(defaultPageRequest)).thenReturn(page);

        // when
        classUnderTest.getAll(defaultPageRequest);

        // then
        verify(sourceService).getAll(defaultPageRequest);
    }

    @Test
    public void pageRequestShouldBeFirstPageOf20SourcesSortedByAscTitle() throws Exception {
        // given
        when(sourceService.getAll(defaultPageRequest)).thenReturn(page);

        // when
        mockMvc.perform(get("/sources"));

        // then
        verify(sourceService).getAll(captor.capture());
        PageRequest usedPageRequest = captor.getValue();
        assertThat(usedPageRequest).isEqualTo(defaultPageRequest);
    }

    @Test
    public void pageRequestShouldBeSecondPageOfSources() throws Exception {
        // given
        PageRequest secondPage = PageRequest.of(1, 20, Sort.by(Sort.Direction.ASC, "title"));
        when(sourceService.getAll(secondPage)).thenReturn(page);

        // when
        mockMvc.perform(get("/sources?page=1"));

        // then
        verify(sourceService).getAll(captor.capture());
        PageRequest usedPageRequest = captor.getValue();
        assertThat(usedPageRequest).isEqualTo(secondPage);
    }

    @Test
    public void pageRequestShouldBePageOf5Sources() throws Exception {
        // given
        PageRequest pageOfFiveSources = PageRequest.of(0, 5, Sort.by(Sort.Direction.ASC, "title"));
        when(sourceService.getAll(pageOfFiveSources)).thenReturn(page);

        // when
        mockMvc.perform(get("/sources?size=5"));

        // then
        verify(sourceService).getAll(captor.capture());
        PageRequest usedPageRequest = captor.getValue();
        assertThat(usedPageRequest).isEqualTo(pageOfFiveSources);
    }

    @Test
    public void pageRequestShouldBePageOfSourcesSortedByDescTitle() throws Exception {
        // given
        PageRequest pageSortedByDescTitle = PageRequest.of(0, 20, Sort.by(Sort.Direction.DESC, "title"));
        when(sourceService.getAll(pageSortedByDescTitle)).thenReturn(page);

        // when
        mockMvc.perform(get("/sources?sort=title,desc"));

        // then
        verify(sourceService).getAll(captor.capture());
        PageRequest usedPageRequest = captor.getValue();
        assertThat(usedPageRequest).isEqualTo(pageSortedByDescTitle);
    }
}