package dev.cb.w40kapi.persistence;

import dev.cb.w40kapi.business.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
