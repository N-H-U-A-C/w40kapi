package dev.cb.w40kapi.controller;

import dev.cb.w40kapi.business.domain.Source;
import dev.cb.w40kapi.business.service.SourceService;
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
 * {@code "/sources"}
 * REST controller for all {@link dev.cb.w40kapi.business.domain.Source} related HTTP requests.
 *
 * @author N.H.U.A.C
 * @version 1.0
 */
@RestController
@RequestMapping("/sources")
public class SourceController {

    private SourceService sourceService;

    /**
     * Creates a new {@link SourceController}.
     *
     * @param sourceService the {@link SourceService} used for the initialization.
     */
    public SourceController(SourceService sourceService) {
        this.sourceService = sourceService;
    }

    /**
     * {@code GET "/"}
     * Returns a {@code List} of {@link Source}. By default, creates the {@code List} from the first {@link Page} of 20 {@code Source} sorted by ascending title.
     *
     * @param pageable the url parameters, can modify the page number, the page size and the page sorting.
     * @return a {@link ResponseEntity} with status code {@code 200 (OK)} and with body a {@code List} of {@code Source}.
     */
    @GetMapping()
    public ResponseEntity<List<Source>> getAll(Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                pageable.getSortOr(Sort.by(Sort.Direction.ASC, "title")));

        Page<Source> page = sourceService.getAll(pageRequest);

        return ResponseEntity.ok(page.getContent());
    }
}