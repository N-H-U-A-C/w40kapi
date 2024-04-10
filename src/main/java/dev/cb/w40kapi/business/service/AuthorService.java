package dev.cb.w40kapi.business.service;

import dev.cb.w40kapi.business.domain.Author;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

/**
 * Interface for business logic for {@link Author}.
 *
 * @author N.H.U.A.C
 * @version 1.0
 */
public interface AuthorService {

    /**
     * Returns a {@link Slice} of {@link Author} meeting the paging restriction provided in the {@link Pageable} object.
     *
     * @param pageable the {@code Pageable} to request a sliced result.
     * @return a {@code Slice} of {@code Author}.
     */
    Slice<Author> getAll(Pageable pageable);
}