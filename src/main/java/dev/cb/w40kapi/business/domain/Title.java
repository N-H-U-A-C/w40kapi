package dev.cb.w40kapi.business.domain;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * Class that models the title an {@code dev.cb.w40kapi.business.domain.Author} can have. A title has an id and a name.
 *
 * @author N.H.U.A.C
 * @version 1.0
 */
@Entity
@Table(name = "titles")
public class Title {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_title")
    private Integer id;
    @Column(name = "name_title")
    private String name;

    /**
     * Creates a new {@code Title}.
     */
    protected Title() {
    }

    /**
     * Creates a new {@code Title}.
     *
     * @param id   the id used for the initialization.
     * @param name the name used for the initialization.
     */
    public Title(Integer id, String name) {
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
        Title title = (Title) o;
        return Objects.equals(getId(), title.getId()) && Objects.equals(getName(), title.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    @Override
    public String toString() {
        return "Title{" +
               "id=" + id +
               ", name='" + name + '\'' +
               '}';
    }
}