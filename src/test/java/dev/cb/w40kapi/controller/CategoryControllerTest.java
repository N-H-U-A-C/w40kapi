package dev.cb.w40kapi.controller;

import dev.cb.w40kapi.business.domain.Category;
import dev.cb.w40kapi.business.service.CategoryService;
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

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(CategoryController.class)
class CategoryControllerTest {

    @Autowired
    private CategoryController classUnderTest;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

    private PageRequest defaultPageRequest;
    private Page<Category> page;

    @Captor
    private ArgumentCaptor<PageRequest> captor;

    @BeforeEach
    public void setUp() {
        defaultPageRequest = PageRequest.of(0, 20, Sort.by(Sort.Direction.ASC, "name"));
        page = new PageImpl<>(List.of(new Category(55, "Test"),
                new Category(1, "Ok")));
    }

    @Test
    public void shouldCallGetAllOfCategoryService() {
        // given
        when(categoryService.getAll(defaultPageRequest)).thenReturn(page);

        // when
        classUnderTest.getAll(defaultPageRequest);

        // then
        verify(categoryService).getAll(defaultPageRequest);
    }

    @Test
    public void pageRequestShouldBeFirstPageOf20CategoriesSortedByAscName() throws Exception {
        // given
        when(categoryService.getAll(defaultPageRequest)).thenReturn(page);

        // when
        mockMvc.perform(get("/categories"));

        // then
        verify(categoryService).getAll(captor.capture());
        PageRequest usedPageRequest = captor.getValue();
        assertThat(usedPageRequest).isEqualTo(defaultPageRequest);
    }

    @Test
    public void pageRequestShouldBeSecondPageOfCategories() throws Exception {
        // given
        PageRequest secondPage = PageRequest.of(1, 20, Sort.by(Sort.Direction.ASC, "name"));
        when(categoryService.getAll(secondPage)).thenReturn(page);

        // when
        mockMvc.perform(get("/categories?page=1"));

        // then
        verify(categoryService).getAll(captor.capture());
        PageRequest usedPageRequest = captor.getValue();
        assertThat(usedPageRequest).isEqualTo(secondPage);
    }

    @Test
    public void pageRequestShouldBePageOf5Categories() throws Exception {
        // given
        PageRequest pageOfFiveCategories = PageRequest.of(0, 5, Sort.by(Sort.Direction.ASC, "name"));
        when(categoryService.getAll(pageOfFiveCategories)).thenReturn(page);

        // when
        mockMvc.perform(get("/categories?size=5"));

        // then
        verify(categoryService).getAll(captor.capture());
        PageRequest usedPageRequest = captor.getValue();
        assertThat(usedPageRequest).isEqualTo(pageOfFiveCategories);
    }

    @Test
    public void pageRequestShouldBePageOfCategoriesSortedByDescName() throws Exception {
        // given
        PageRequest pageSortedByDescName = PageRequest.of(0, 20, Sort.by(Sort.Direction.DESC, "name"));
        when(categoryService.getAll(pageSortedByDescName)).thenReturn(page);

        // when
        mockMvc.perform(get("/categories?sort=name,desc"));

        // then
        verify(categoryService).getAll(captor.capture());
        PageRequest usedPageRequest = captor.getValue();
        assertThat(usedPageRequest).isEqualTo(pageSortedByDescName);
    }
}