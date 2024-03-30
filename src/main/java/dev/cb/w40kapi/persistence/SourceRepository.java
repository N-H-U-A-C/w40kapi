package dev.cb.w40kapi.persistence;

import dev.cb.w40kapi.business.domain.Source;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Interface for CRUD operations for {@link Source}.
 *
 * @author N.H.U.A.C
 * @version 1.0
 */
public interface SourceRepository extends CrudRepository<Source, Integer>, PagingAndSortingRepository<Source, Integer> {
}
