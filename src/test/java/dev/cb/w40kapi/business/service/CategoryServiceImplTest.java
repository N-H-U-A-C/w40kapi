package dev.cb.w40kapi.business.service;

import dev.cb.w40kapi.persistence.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

    @InjectMocks
    private CategoryServiceImpl classUnderTest;
    @Mock
    private CategoryRepository categoryRepository;
    private Pageable pageable;

    @BeforeEach
    public void setUp() {
        pageable = PageRequest.of(0, 20, Sort.by(Sort.Direction.ASC, "name"));
    }

    @Test
    public void shouldCallFindAllCategoryDtoOfCategoryRepository() {
        // given

        // when
        classUnderTest.getAllCategoryDto(pageable);

        // then
        verify(categoryRepository).findAllCategoryDto(pageable);
    }
}