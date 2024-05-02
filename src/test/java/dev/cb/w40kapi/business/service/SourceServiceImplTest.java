package dev.cb.w40kapi.business.service;

import dev.cb.w40kapi.persistence.SourceRepository;
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
public class SourceServiceImplTest {

    @InjectMocks
    private SourceServiceImpl classUnderTest;
    @Mock
    private SourceRepository sourceRepository;
    private Pageable pageable;

    @BeforeEach
    void setUp() {
        pageable = PageRequest.of(0, 20, Sort.by(Sort.Direction.ASC, "name"));
    }

    @Test
    public void shouldCallFindAllSourceDtoOfSourceRepository() {
        // given

        // when
        classUnderTest.getAllSourceDto(pageable);

        // then
        verify(sourceRepository).findAllSourceDto(pageable);
    }
}