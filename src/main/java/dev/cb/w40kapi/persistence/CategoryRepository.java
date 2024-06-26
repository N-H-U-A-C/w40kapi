package dev.cb.w40kapi.persistence;

import dev.cb.w40kapi.business.domain.Category;
import dev.cb.w40kapi.business.service.dto.CategoryDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Interface for CRUD operations for {@link Category}.
 *
 * @author N.H.U.A.C
 * @version 1.0
 */
public interface CategoryRepository extends CrudRepository<Category, Integer>, PagingAndSortingRepository<Category, Integer> {

    /**
     * Returns a {@link Slice} of {@link CategoryDto} meeting the paging restriction provided in the {@link Pageable} object.
     *
     * @param pageable the {@code Pageable} to request a sliced result.
     * @return a {@code Slice} of {@code CategoryDto}.
     */
    @Query("""
            SELECT new dev.cb.w40kapi.business.service.dto.CategoryDto(
                c.id as id,
                c.name as name
            )
            FROM Category c
            """)
    Slice<CategoryDto> findAllCategoryDto(Pageable pageable);
}