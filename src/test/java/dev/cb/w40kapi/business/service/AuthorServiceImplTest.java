package dev.cb.w40kapi.business.service;

import dev.cb.w40kapi.persistence.AuthorRepository;
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
class AuthorServiceImplTest {

    @InjectMocks
    private AuthorServiceImpl classUnderTest;
    @Mock
    private AuthorRepository authorRepository;
    private Pageable pageable;

    @BeforeEach
    public void setUp() {
        pageable = PageRequest.of(0, 20, Sort.by(Sort.Direction.ASC, "name"));
    }

    @Test
    public void shouldCallFindAllOfAuthorRepository() {
        // given

        // when
        classUnderTest.getAll(pageable);

        // then
        verify(authorRepository).findAll(pageable);
    }
}