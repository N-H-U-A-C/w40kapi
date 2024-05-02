package dev.cb.w40kapi.business.service;

import dev.cb.w40kapi.business.domain.Category;
import dev.cb.w40kapi.business.service.dto.CategoryDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

/**
 * Interface for business logic for {@link Category}.
 *
 * @author N.H.U.A.C
 * @version 1.0
 */
public interface CategoryService {

    /**
     * Returns a {@link Slice} of {@link CategoryDto} meeting the paging restriction provided in the {@link Pageable} object.
     *
     * @param pageable the {@code Pageable} to request a sliced result.
     * @return a {@code Slice} of {@code CategoryDto}.
     */
    Slice<CategoryDto> getAllCategoryDto(Pageable pageable);
}