package dev.cb.w40kapi.business.service;

import dev.cb.w40kapi.business.service.dto.SourceDto;
import dev.cb.w40kapi.persistence.SourceRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
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
    public Slice<SourceDto> getAllSourceDto(Pageable pageable) {
        return sourceRepository.findAllSourceDto(pageable);
    }
}