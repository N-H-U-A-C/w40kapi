package dev.cb.w40kapi.persistence;

import dev.cb.w40kapi.business.service.dto.SourceDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;

import java.time.Year;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class SourceRepositoryTest {

    @Autowired
    private SourceRepository classUnderTest;

    @Test
    public void shouldReturnFirstSliceOfSourcesDtoSortedByAscName() {
        // given
        Pageable pageable = PageRequest.of(0, 20, Sort.by(Sort.Direction.ASC, "name"));
        List<SourceDto> expected = List.of(
                new SourceDto(4, "Codex", Year.of(1998)),
                new SourceDto(5, "Dummy Book", Year.of(1950)),
                new SourceDto(1, "Rulebook (3rd Ed.)", Year.of(1998)),
                new SourceDto(2, "Rulebook (4th Ed.)", Year.of(2004)),
                new SourceDto(3, "Rulebook (5th Ed.)", Year.of(2008))
        );

        // when
        Slice<SourceDto> result = classUnderTest.findAllSourceDto(pageable);

        // then
        assertThat(result.getContent()).isEqualTo(expected);
    }
}