package dev.cb.w40kapi.business.service;

import dev.cb.w40kapi.business.domain.Category;
import dev.cb.w40kapi.persistence.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link CategoryService} interface.
 *
 * @author N.H.U.A.C
 * @version 1.0
 * @see Category
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    /**
     * Creates a new {@code CategoryServiceImpl}.
     *
     * @param categoryRepository the {@link CategoryRepository} used for the initialization.
     */
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Page<Category> getAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }
}
