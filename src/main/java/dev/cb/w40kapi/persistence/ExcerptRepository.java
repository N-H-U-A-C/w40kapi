package dev.cb.w40kapi.persistence;

import dev.cb.w40kapi.business.domain.Excerpt;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface for CRUD operations for {@link Excerpt}.
 *
 * @author N.H.U.A.C
 * @version 1.0
 */
public interface ExcerptRepository extends CrudRepository<Excerpt, Integer> {
}