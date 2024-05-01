package dev.cb.w40kapi.persistence;

import dev.cb.w40kapi.business.service.dto.CategoryDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository classUnderTest;

    @Test
    public void shouldReturnFirstSliceOf20CategoriesDtoSortedByAscName() {
        // given
        Pageable pageable = PageRequest.of(0, 20, Sort.by(Sort.Direction.ASC, "name"));
        List<CategoryDto> expected = List.of(
                new CategoryDto(10, "10th"),
                new CategoryDto(11, "11th"),
                new CategoryDto(12, "12th"),
                new CategoryDto(13, "13th"),
                new CategoryDto(14, "14th"),
                new CategoryDto(15, "15th"),
                new CategoryDto(16, "16th"),
                new CategoryDto(17, "17th"),
                new CategoryDto(18, "18th"),
                new CategoryDto(19, "19th"),
                new CategoryDto(20, "20th"),
                new CategoryDto(21, "21th"),
                new CategoryDto(3, "3rd"),
                new CategoryDto(4, "4th"),
                new CategoryDto(5, "5th"),
                new CategoryDto(6, "6th"),
                new CategoryDto(7, "7th"),
                new CategoryDto(8, "8th"),
                new CategoryDto(9, "9th"),
                new CategoryDto(2, "Military")
        );

        // when
        Slice<CategoryDto> result = classUnderTest.findAllCategoryDto(pageable);

        // then
        assertThat(result.getContent()).isEqualTo(expected);
    }
}