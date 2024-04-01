package dev.cb.w40kapi.persistence;

import dev.cb.w40kapi.business.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Interface for CRUD operations for {@link Author}.
 *
 * @author N.H.U.A.C
 * @version 1.0
 */
public interface AuthorRepository extends CrudRepository<Author, Integer>, PagingAndSortingRepository<Author, Integer> {
}
