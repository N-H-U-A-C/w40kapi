package dev.cb.w40kapi.business.service;

import dev.cb.w40kapi.persistence.TitleRepository;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link TitleService} interface.
 *
 * @author N.H.U.A.C
 * @version 1.0
 * @see dev.cb.w40kapi.business.domain.Title
 */
@Service
public class TitleServiceImpl implements TitleService {

    private TitleRepository titleRepository;

    /**
     * Creates a new {@code TitleServiceImpl}.
     *
     * @param titleRepository the {@link dev.cb.w40kapi.persistence.TitleRepository} used for the initialization.
     */
    public TitleServiceImpl(TitleRepository titleRepository) {
        this.titleRepository = titleRepository;
    }
}