package dev.cb.w40kapi.business.service;

import dev.cb.w40kapi.persistence.ExcerptRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ExcerptServiceImplTest {

    @InjectMocks
    private ExcerptServiceImpl classUnderTest;
    @Mock
    private ExcerptRepository excerptRepository;
    private Integer id;

    @BeforeEach
    public void setUp() {
        id = Integer.valueOf(1);
    }

    @Test
    public void shouldCallFindByIdOfExcerptRepository() {
        // given

        // when
        classUnderTest.getById(id);

        // then
        verify(excerptRepository).findById(id);
    }
}