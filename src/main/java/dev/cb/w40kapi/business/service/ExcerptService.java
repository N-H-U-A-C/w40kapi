package dev.cb.w40kapi.business.service;

import dev.cb.w40kapi.business.domain.Excerpt;

import java.util.Optional;

/**
 * Interface for business logic for {@link dev.cb.w40kapi.business.domain.Excerpt}.
 *
 * @author N.H.U.A.C
 * @version 1.0
 */
public interface ExcerptService {

    /**
     * Returns an {@link Excerpt} by its id.
     *
     * @param id the {@code Excerpt} id.
     * @return an {@code Optional} with the {@code Excerpt} with the given id if the {@code Excerpt} exists, otherwise an empty {@code Optional}.
     */
    Optional<Excerpt> getById(Integer id);
}