package dev.cb.w40kapi.business.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

/**
 * Class that models the category an {@code dev.cb.w40kapi.business.domain.Excerpt} can have. A category has an id and a name.
 *
 * @author N.H.U.A.C
 * @version 1.0
 */
@Entity
@Table(name = "CATEGORIES")
public class Category {

    @Id
    @Column(name = "ID_CATEGORY")
    private Integer id;
    @Column(name = "NAME_CATEGORY")
    private String name;

    /**
     * Creates a new {@code Category}.
     */
    protected Category() {
    }

    /**
     * Creates a new {@code Category}.
     *
     * @param id   the id used for the initialization.
     * @param name the name used for the initialization.
     */
    public Category(Integer id, String name) {
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
        Category category = (Category) o;
        return Objects.equals(getId(), category.getId()) && Objects.equals(getName(), category.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    @Override
    public String toString() {
        return "Category{" +
               "id=" + id +
               ", name='" + name + '\'' +
               '}';
    }
}