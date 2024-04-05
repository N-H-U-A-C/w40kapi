package dev.cb.w40kapi.persistence;

import dev.cb.w40kapi.business.domain.Title;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Interface for CRUD operations for {@link Title}.
 *
 * @author N.H.U.A.C
 * @version 1.0
 */
public interface TitleRepository extends CrudRepository<Title, Integer>, PagingAndSortingRepository<Title, Integer> {
}
