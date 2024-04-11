package dev.cb.w40kapi.business.service;

import dev.cb.w40kapi.business.domain.Source;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

/**
 * Interface for business logic for {@link dev.cb.w40kapi.business.domain.Source}.
 *
 * @author N.H.U.A.C
 * @version 1.0
 */
public interface SourceService {

    /**
     * Returns a {@link Slice} of {@link dev.cb.w40kapi.business.domain.Source} meeting the paging restriction provided in the {@link Pageable} object.
     *
     * @param pageable the {@code Pageable} to request a sliced result.
     * @return a {@code Slice} of {@code Source}.
     */
    Slice<Source> getAll(Pageable pageable);
}