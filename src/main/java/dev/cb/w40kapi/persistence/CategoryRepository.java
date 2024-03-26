package dev.cb.w40kapi.persistence;

import dev.cb.w40kapi.business.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Interface for CRUD operations for {@link Category}.
 *
 * @author N.H.U.A.C
 * @version 1.0
 */
public interface CategoryRepository extends CrudRepository<Category, Integer>, PagingAndSortingRepository<Category, Integer> {
}
