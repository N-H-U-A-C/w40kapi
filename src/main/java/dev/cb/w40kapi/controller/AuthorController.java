package dev.cb.w40kapi.controller;

import dev.cb.w40kapi.business.domain.Author;
import dev.cb.w40kapi.business.service.AuthorService;
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
 * {@code "/authors"}
 * REST controller for all {@link Author} related HTTP requests.
 *
 * @author N.H.U.A.C
 * @version 1.0
 */
@RestController
@RequestMapping("/authors")
public class AuthorController {

    private AuthorService authorService;

    /**
     * Creates a new {@code AuthorController}.
     *
     * @param authorService the {@link AuthorService} used for the initialization.
     */
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    /**
     * {@code GET "/"}
     * Returns a {@code List} of {@link Author}. By default, creates the {@code List} from the first {@link Page} of 20 {@code Author} sorted by ascending name.
     *
     * @param pageable the url parameters, can modify the page number, the page size and the page sorting.
     * @return a {@link ResponseEntity} with status code {@code 200 (OK)} and with body a {@code List} of {@code Author}.
     */
    @GetMapping()
    public ResponseEntity<List<Author>> getAll(Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                pageable.getSortOr(Sort.by(Sort.Direction.ASC, "name"))
        );
        Page<Author> page = authorService.getAll(pageRequest);

        return ResponseEntity.ok(page.getContent());
    }
}
