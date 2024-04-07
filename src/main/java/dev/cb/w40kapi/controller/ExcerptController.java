package dev.cb.w40kapi.controller;

import dev.cb.w40kapi.business.domain.Excerpt;
import dev.cb.w40kapi.business.service.ExcerptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * {@code "/excerpts"}
 * REST controller for all {@link dev.cb.w40kapi.business.domain.Excerpt} related HTTP requests.
 *
 * @author N.H.U.A.C
 * @version 1.0
 */
@RestController
@RequestMapping("/excerpts")
public class ExcerptController {

    private ExcerptService excerptService;

    /**
     * Creates a new {@code ExcerptController}.
     *
     * @param excerptService the {@link ExcerptService} used for the initialization.
     */
    public ExcerptController(ExcerptService excerptService) {
        this.excerptService = excerptService;
    }

    /**
     * {@code GET "/{id}"}
     * Returns an {@link Excerpt} by its id.
     *
     * @param id the {@code Excerpt} id.
     * @return a {@link ResponseEntity} with status code {@code 200 (OK)} and with body the {@code Excerpt} for the given id if the {@code Excerpt} exists, otherwise a {@code ResponseEntity} with status code {@code 404 (NOT FOUND)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Excerpt> getById(@PathVariable Integer id) {
        Optional<Excerpt> excerptOptional = excerptService.getById(id);

//        if (excerptOptional.isPresent()) {
//            responseEntity = ResponseEntity.ok(excerptOptional.get());
//        } else {
//            responseEntity = ResponseEntity.notFound().build();
//        }

        return excerptOptional.isPresent() ? ResponseEntity.ok(excerptOptional.get()) : ResponseEntity.notFound().build();
    }
}