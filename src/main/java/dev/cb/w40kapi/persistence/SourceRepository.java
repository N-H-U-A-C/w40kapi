package dev.cb.w40kapi.persistence;

import dev.cb.w40kapi.business.domain.Source;
import dev.cb.w40kapi.business.service.dto.SourceDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Interface for CRUD operations for {@link Source}.
 *
 * @author N.H.U.A.C
 * @version 1.0
 */
public interface SourceRepository extends CrudRepository<Source, Integer>, PagingAndSortingRepository<Source, Integer> {

    /**
     * Returns a {@link Slice} of {@link SourceDto} meeting the paging restriction provided in the {@link Pageable} object.
     *
     * @param pageable the {@code Pageable} to request a sliced result.
     * @return a {@code Slice} of {@code SourceDto}.
     */
    @Query("""
            SELECT new dev.cb.w40kapi.business.service.dto.SourceDto(
                s.id as id,
                s.name as name,
                s.publication as publication
            )
            FROM Source s
            """)
    Slice<SourceDto> findAllSourceDto(Pageable pageable);
}