package dev.cb.w40kapi.business.service;

import dev.cb.w40kapi.business.domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface CategoryService {

    //    Iterable<Category> getAll();

    Page<Category> getAll(PageRequest pageRequest);

}
