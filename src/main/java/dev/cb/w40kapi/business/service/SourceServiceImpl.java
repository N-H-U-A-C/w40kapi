package dev.cb.w40kapi.business.service;

import dev.cb.w40kapi.business.domain.Source;
import dev.cb.w40kapi.persistence.SourceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link SourceService} interface.
 *
 * @author N.H.U.A.C
 * @version 1.0
 * @see dev.cb.w40kapi.business.domain.Source
 */
@Service
public class SourceServiceImpl implements SourceService {

    private SourceRepository sourceRepository;

    /**
     * Creates a new {@code SourceServiceImpl}.
     *
     * @param sourceRepository the {@link SourceRepository} used for the initialization.
     */
    public SourceServiceImpl(SourceRepository sourceRepository) {
        this.sourceRepository = sourceRepository;
    }

    @Override
    public Page<Source> getAll(Pageable pageable) {
        return sourceRepository.findAll(pageable);
    }
}