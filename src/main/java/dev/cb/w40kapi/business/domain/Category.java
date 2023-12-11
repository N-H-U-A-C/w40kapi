package dev.cb.w40kapi.business.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

public @Table("CATEGORIES") record Category(@Id @Column("ID_CATEGORY") Integer id, @Column("NAME_CATEGORY") String name) {
}
