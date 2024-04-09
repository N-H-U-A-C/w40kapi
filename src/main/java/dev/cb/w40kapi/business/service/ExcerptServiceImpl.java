package dev.cb.w40kapi.business.service;

import dev.cb.w40kapi.business.domain.Excerpt;
import dev.cb.w40kapi.persistence.ExcerptRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of {@link ExcerptService} interface.
 *
 * @author N.H.U.A.C
 * @version 1.0
 * @see Excerpt
 */
@Service
public class ExcerptServiceImpl implements ExcerptService {

    private ExcerptRepository excerptRepository;

    /**
     * Creates a new {@code ExcerptServiceImpl}.
     *
     * @param excerptRepository the {@link ExcerptRepository} used for the initialization.
     */
    public ExcerptServiceImpl(ExcerptRepository excerptRepository) {
        this.excerptRepository = excerptRepository;
    }

    @Override
    public Optional<Excerpt> getById(Integer id) {
        return excerptRepository.findById(id);
    }
}