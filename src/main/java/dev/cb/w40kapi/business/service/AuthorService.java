package dev.cb.w40kapi.business.service;

import dev.cb.w40kapi.business.domain.Author;
import dev.cb.w40kapi.business.domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Interface for business logic for {@link Author}.
 *
 * @author N.H.U.A.C
 * @version 1.0
 */
public interface AuthorService {

    /**
     * Returns a {@link Page} of {@link Author} meeting the paging restriction provided in the {@link Pageable} object.
     *
     * @param pageable the {@code Pageable} to request a paged result.
     * @return a {@code Page} of {@code Author}.
     */
    Page<Author> getAll(Pageable pageable);
}