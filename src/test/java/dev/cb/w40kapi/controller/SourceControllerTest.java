package dev.cb.w40kapi.controller;

import dev.cb.w40kapi.business.domain.Source;
import dev.cb.w40kapi.business.service.SourceService;
import dev.cb.w40kapi.business.service.dto.SourceDto;
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
    private Slice<SourceDto> slice;

    @BeforeEach
    public void setUp() {
        defaultPageRequest = PageRequest.of(0, 20, Sort.by(Sort.Direction.ASC, "name"));
        slice = new PageImpl<>(List.of(
                new SourceDto(33, "Test", Year.of(2011)),
                new SourceDto(5, "Rulebook", Year.of(1998))));
    }

    @Test
    public void shouldCallGetAllSourceDtoOfSourceService() {
        // given
        when(sourceService.getAllSourceDto(defaultPageRequest)).thenReturn(slice);

        // when
        classUnderTest.getAllSourceDto(defaultPageRequest);

        // then
        verify(sourceService).getAllSourceDto(defaultPageRequest);
    }

    @Test
    public void pageRequestShouldBeFirstPageOf20SourcesDtoSortedByAscName() throws Exception {
        // given
        when(sourceService.getAllSourceDto(defaultPageRequest)).thenReturn(slice);

        // when
        mockMvc.perform(get("/sources"));

        // then
        verify(sourceService).getAllSourceDto(captor.capture());
        PageRequest usedPageRequest = captor.getValue();
        assertThat(usedPageRequest).isEqualTo(defaultPageRequest);
    }

    @Test
    public void pageRequestShouldBeSecondPageOfSourcesDto() throws Exception {
        // given
        PageRequest secondPage = PageRequest.of(1, 20, Sort.by(Sort.Direction.ASC, "name"));
        when(sourceService.getAllSourceDto(secondPage)).thenReturn(slice);

        // when
        mockMvc.perform(get("/sources?page=1"));

        // then
        verify(sourceService).getAllSourceDto(captor.capture());
        PageRequest usedPageRequest = captor.getValue();
        assertThat(usedPageRequest).isEqualTo(secondPage);
    }

    @Test
    public void pageRequestShouldBePageOf5SourcesDto() throws Exception {
        // given
        PageRequest pageOfFiveSources = PageRequest.of(0, 5, Sort.by(Sort.Direction.ASC, "name"));
        when(sourceService.getAllSourceDto(pageOfFiveSources)).thenReturn(slice);

        // when
        mockMvc.perform(get("/sources?size=5"));

        // then
        verify(sourceService).getAllSourceDto(captor.capture());
        PageRequest usedPageRequest = captor.getValue();
        assertThat(usedPageRequest).isEqualTo(pageOfFiveSources);
    }

    @Test
    public void pageRequestShouldBePageOfSourcesDtoSortedByDescName() throws Exception {
        // given
        PageRequest pageSortedByDescName = PageRequest.of(0, 20, Sort.by(Sort.Direction.DESC, "name"));
        when(sourceService.getAllSourceDto(pageSortedByDescName)).thenReturn(slice);

        // when
        mockMvc.perform(get("/sources?sort=name,desc"));

        // then
        verify(sourceService).getAllSourceDto(captor.capture());
        PageRequest usedPageRequest = captor.getValue();
        assertThat(usedPageRequest).isEqualTo(pageSortedByDescName);
    }
}