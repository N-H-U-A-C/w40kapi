package dev.cb.w40kapi.business.service;

import dev.cb.w40kapi.business.domain.Source;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Interface for business logic for {@link dev.cb.w40kapi.business.domain.Source}.
 *
 * @author N.H.U.A.C
 * @version 1.0
 */
public interface SourceService {

    /**
     * Returns a {@link Page} of {@link dev.cb.w40kapi.business.domain.Source} meeting the paging restriction provided in the {@link Pageable} object.
     *
     * @param pageable the {@code Pageable} to request a paged result.
     * @return a {@code Page} of {@code Source}.
     */
    Page<Source> getAll(Pageable pageable);
}