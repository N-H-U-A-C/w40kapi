package dev.cb.w40kapi.business.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Record that models the category an {@code dev.cb.w40kapi.business.domain.Excerpt} can have. A category has an id and a name.
 *
 * @param id   an integer.
 * @param name a string.
 * @author N.H.U.A.C
 * @version 1.0
 */
public @Table("CATEGORIES") record Category(@Id @Column("ID_CATEGORY") Integer id,
                                            @Column("NAME_CATEGORY") String name) {
}
