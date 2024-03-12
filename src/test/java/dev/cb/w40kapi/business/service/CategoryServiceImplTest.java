package dev.cb.w40kapi.business.service;

import dev.cb.w40kapi.persistence.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

    private CategoryServiceImpl classUnderTest;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private PageRequest pageRequest;

    @BeforeEach
    void setUp() {
        classUnderTest = new CategoryServiceImpl(categoryRepository);
    }

    @Test
    void shouldGetAll() {
        // given

        // when
        classUnderTest.getAll(pageRequest);

        // then
        verify(categoryRepository).findAll(pageRequest);
    }
}