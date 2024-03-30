package dev.cb.w40kapi.business.domain;

import dev.cb.w40kapi.persistence.SourceRepository;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Year;
import java.util.Objects;

/**
 * Class that models the source an {@code dev.cb.w40kapi.business.domain.Excerpt} can have. A category has an id, a title and can have a publication's year.
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
    @Column(name = "TITLE_SOURCE")
    private String title;
    @Column(name = "PUBLICATION")
    private Year publication;

    protected Source() {
    }

    /**
     * Creates a new {@code Source}.
     *
     * @param id the id used for the initialization.
     * @param title the title used for the initialization.
     * @param publication the {@code Year} used for the initialization.
     */
    public Source(Integer id, String title, Year publication) {
        this.id = id;
        this.title = title;
        this.publication = publication;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Year getPublication() {
        return publication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return Objects.equals(getId(), source.getId()) && Objects.equals(getTitle(), source.getTitle()) && Objects.equals(getPublication(), source.getPublication());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getPublication());
    }
}