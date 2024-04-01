package dev.cb.w40kapi.business.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

/**
 * Class that models the author an {@code dev.cb.w40kapi.business.domain.Excerpt} can have. An author has an id and a name.
 *
 * @author N.H.U.A.C
 * @version 1.0
 */
@Entity
@Table(name = "AUTHORS")
public class Author {

    @Id
    @Column(name = "ID_AUTHOR")
    private Integer id;
    @Column(name = "NAME_AUTHOR")
    private String name;

    /**
     * Creates a new {@code Author}.
     */
    protected Author() {
    }

    /**
     * Creates a new {@code Author}.
     *
     * @param id   the id used for the initialization.
     * @param name the name used for the initialization.
     */
    public Author(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author1 = (Author) o;
        return Objects.equals(getId(), author1.getId()) && Objects.equals(getName(), author1.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
