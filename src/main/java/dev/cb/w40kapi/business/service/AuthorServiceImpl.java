package dev.cb.w40kapi.business.service;

import dev.cb.w40kapi.business.domain.Author;
import dev.cb.w40kapi.business.domain.Category;
import dev.cb.w40kapi.persistence.AuthorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link AuthorService} interface.
 *
 * @author N.H.U.A.C
 * @version 1.0
 * @see Author
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    /**
     * Creates a new {@code AuthorServiceImpl}.
     *
     * @param authorRepository the {@link AuthorRepository} used for the initialization.
     */
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Page<Author> getAll(Pageable pageable) {
        return authorRepository.findAll(pageable);
    }
}
