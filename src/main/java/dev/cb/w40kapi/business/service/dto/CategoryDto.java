package dev.cb.w40kapi.business.service.dto;

/**
 * Record that models the projection of an {@code dev.cb.w40kapi.business.domain.Category}. This projection has an id and a name.
 * *
 * * @author N.H.U.A.C
 * * @version 1.0
 */
public record CategoryDto(
        Integer id,
        String name
) {
}