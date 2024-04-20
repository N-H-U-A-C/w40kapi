package dev.cb.w40kapi.business.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Year;
import java.util.Objects;

/**
 * Class that models the source an {@code dev.cb.w40kapi.business.domain.Excerpt} can have. A source has an id, a name and can have a publication's year.
 * *
 * * @author N.H.U.A.C
 * * @version 1.0
 */
@Entity
@Table(name = "SOURCES")
public class Source {

    @Id
    @Column(name = "ID_SOURCE")
    private Integer id;
    @Column(name = "NAME_SOURCE")
    private String name;
    @Column(name = "PUBLICATION")
    private Year publication;

    /**
     * Creates a new {@code Source}.
     */
    protected Source() {
    }

    /**
     * Creates a new {@code Source}.
     *
     * @param id          the id used for the initialization.
     * @param name        the name used for the initialization.
     * @param publication the {@code Year} used for the initialization.
     */
    public Source(Integer id, String name, Year publication) {
        this.id = id;
        this.name = name;
        this.publication = publication;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Year getPublication() {
        return publication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return Objects.equals(getId(), source.getId()) && Objects.equals(getName(), source.getName()) && Objects.equals(getPublication(), source.getPublication());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPublication());
    }

    @Override
    public String toString() {
        return "Source{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", publication=" + publication +
               '}';
    }
}