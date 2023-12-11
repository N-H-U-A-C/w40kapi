package dev.cb.w40kapi.controller;

import dev.cb.w40kapi.business.domain.Category;
import dev.cb.w40kapi.business.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public ResponseEntity<Iterable<Category>> getAll() {
        return ResponseEntity.ok(categoryService.getAll());
    }
}
