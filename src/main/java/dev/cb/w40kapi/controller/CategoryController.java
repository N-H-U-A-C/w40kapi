package dev.cb.w40kapi.controller;

import dev.cb.w40kapi.business.domain.Category;
import dev.cb.w40kapi.business.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * {@code "/categories"}
 * REST controller for all {@link Category} related HTTP requests.
 *
 * @author N.H.U.A.C
 * @version 1.0
 */
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    /**
     * Creates a new {@link CategoryController}.
     *
     * @param categoryService the {@link CategoryService} used for the initialization.
     */
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * {@code GET "/"}
     * Returns a {@code List} of {@link Category}. By default, creates the {@code List} from the first {@link Page} of 20 {@code Category} sorted by ascending name.
     *
     * @param pageable the url parameters, can modify the page number, the page size and the page sorting.
     * @return a {@link ResponseEntity} with status code {@code 200 (OK)} and with body a {@code List} of {@code Category}.
     */
    @GetMapping()
    public ResponseEntity<List<Category>> getAll(Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                pageable.getSortOr(Sort.by(Sort.Direction.ASC, "name"))
        );
        Page<Category> page = categoryService.getAll(pageRequest);

        return ResponseEntity.ok(page.getContent());
    }
}
