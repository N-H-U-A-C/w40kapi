package dev.cb.w40kapi.business.service;

import dev.cb.w40kapi.business.domain.Category;
import dev.cb.w40kapi.persistence.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

//    public Iterable<Category> getAll() {
//        return categoryRepository.findAll();
//    }

    public Page<Category> getAll(PageRequest pageRequest) {
        return categoryRepository.findAll(pageRequest);
    }
}
