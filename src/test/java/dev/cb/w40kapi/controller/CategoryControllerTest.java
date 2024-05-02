package dev.cb.w40kapi.controller;

import dev.cb.w40kapi.business.service.CategoryService;
import dev.cb.w40kapi.business.service.dto.CategoryDto;
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

@WebMvcTest(CategoryController.class)
class CategoryControllerTest {

    @Autowired
    private CategoryController classUnderTest;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CategoryService categoryService;
    private PageRequest defaultPageRequest;
    @Captor
    private ArgumentCaptor<PageRequest> captor;
    private Slice<CategoryDto> slice;

    @BeforeEach
    public void setUp() {
        defaultPageRequest = PageRequest.of(0, 20, Sort.by(Sort.Direction.ASC, "name"));
        slice = new PageImpl<>(List.of(
                new CategoryDto(55, "Test"),
                new CategoryDto(1, "Ok")));
    }

    @Test
    public void shouldCallGetAllCategoryDtoOfCategoryService() {
        // given
        when(categoryService.getAllCategoryDto(defaultPageRequest)).thenReturn(slice);

        // when
        classUnderTest.getAllCategoryDto(defaultPageRequest);

        // then
        verify(categoryService).getAllCategoryDto(defaultPageRequest);
    }

    @Test
    public void pageRequestShouldBeFirstPageOf20CategoriesDtoSortedByAscName() throws Exception {
        // given
        when(categoryService.getAllCategoryDto(defaultPageRequest)).thenReturn(slice);

        // when
        mockMvc.perform(get("/categories"));

        // then
        verify(categoryService).getAllCategoryDto(captor.capture());
        PageRequest usedPageRequest = captor.getValue();
        assertThat(usedPageRequest).isEqualTo(defaultPageRequest);
    }

    @Test
    public void pageRequestShouldBeSecondPageOfCategoriesDto() throws Exception {
        // given
        PageRequest secondPage = PageRequest.of(1, 20, Sort.by(Sort.Direction.ASC, "name"));
        when(categoryService.getAllCategoryDto(secondPage)).thenReturn(slice);

        // when
        mockMvc.perform(get("/categories?page=1"));

        // then
        verify(categoryService).getAllCategoryDto(captor.capture());
        PageRequest usedPageRequest = captor.getValue();
        assertThat(usedPageRequest).isEqualTo(secondPage);
    }

    @Test
    public void pageRequestShouldBePageOf5CategoriesDto() throws Exception {
        // given
        PageRequest pageOfFiveCategories = PageRequest.of(0, 5, Sort.by(Sort.Direction.ASC, "name"));
        when(categoryService.getAllCategoryDto(pageOfFiveCategories)).thenReturn(slice);

        // when
        mockMvc.perform(get("/categories?size=5"));

        // then
        verify(categoryService).getAllCategoryDto(captor.capture());
        PageRequest usedPageRequest = captor.getValue();
        assertThat(usedPageRequest).isEqualTo(pageOfFiveCategories);
    }

    @Test
    public void pageRequestShouldBePageOfCategoriesDtoSortedByDescName() throws Exception {
        // given
        PageRequest pageSortedByDescName = PageRequest.of(0, 20, Sort.by(Sort.Direction.DESC, "name"));
        when(categoryService.getAllCategoryDto(pageSortedByDescName)).thenReturn(slice);

        // when
        mockMvc.perform(get("/categories?sort=name,desc"));

        // then
        verify(categoryService).getAllCategoryDto(captor.capture());
        PageRequest usedPageRequest = captor.getValue();
        assertThat(usedPageRequest).isEqualTo(pageSortedByDescName);
    }
}