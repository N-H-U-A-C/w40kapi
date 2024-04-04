package dev.cb.w40kapi.business.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
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

    @ManyToMany
    @JoinTable(name = "DESIGNATE",
            joinColumns = @JoinColumn(name = "ID_AUTHOR"),
            inverseJoinColumns = @JoinColumn(name = "ID_TITLE"))
    @JsonIgnore
    private List<Title> titles = new ArrayList<>();

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

    /**
     * Creates a new {@code Author}.
     *
     * @param id     the id used for the initialization.
     * @param name   the name used for the initialization.
     * @param titles the list of titles used for the initialization.
     */
    public Author(Integer id, String name, List<Title> titles) {
        this.id = id;
        this.name = name;
        this.titles = titles;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Title> getTitles() {
        return titles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(getId(), author.getId()) && Objects.equals(getName(), author.getName()) && Objects.equals(getTitles(), author.getTitles());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getTitles());
    }
}