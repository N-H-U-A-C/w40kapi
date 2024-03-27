package dev.cb.w40kapi.business.service;

import dev.cb.w40kapi.business.domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Interface for business logic for {@link Category}.
 *
 * @author N.H.U.A.C
 * @version 1.0
 */
public interface CategoryService {

    /**
     * Returns a {@link Page} of {@link Category} meeting the paging restriction provided in the {@link Pageable} object.
     *
     * @param pageable the {@code Pageable} to request a paged result.
     * @return a {@code Page} of {@code Category}.
     */
    Page<Category> getAll(Pageable pageable);

}
