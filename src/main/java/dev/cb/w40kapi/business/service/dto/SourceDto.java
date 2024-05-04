package dev.cb.w40kapi.business.service.dto;

import java.time.Year;

/**
 * Record that models the projection of an {@code dev.cb.w40kapi.business.domain.Source}. This projection has an id, a name and can have a publication's year.
 * *
 * * @author N.H.U.A.C
 * * @version 1.0
 */
public record SourceDto(
        Integer id,
        String name,
        Year publication
) {
}