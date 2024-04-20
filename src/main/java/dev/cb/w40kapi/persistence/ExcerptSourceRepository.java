package dev.cb.w40kapi.persistence;

import dev.cb.w40kapi.business.domain.ExcerptSource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Interface for CRUD operations for {@link ExcerptSource}.
 *
 * @author N.H.U.A.C
 * @version 1.0
 */
public interface ExcerptSourceRepository extends CrudRepository<ExcerptSource, ExcerptSource.ExcerptSourceId>, PagingAndSortingRepository<ExcerptSource, ExcerptSource.ExcerptSourceId> {
}