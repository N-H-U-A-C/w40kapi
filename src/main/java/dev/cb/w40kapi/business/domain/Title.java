package dev.cb.w40kapi.business.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class that models the title an {@code dev.cb.w40kapi.business.domain.Author} can have. A title has an id and a name.
 *
 * @author N.H.U.A.C
 * @version 1.0
 */
@Entity
@Table(name = "TITLES")
public class Title {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TITLE")
    private Integer id;
    @Column(name = "NAME_TITLE")
    private String name;

    @ManyToMany
    @JoinTable(name = "DESIGNATE",
            joinColumns = @JoinColumn(name = "ID_TITLE"),
            inverseJoinColumns = @JoinColumn(name = "ID_AUTHOR"))
    @JsonIgnore
    private List<Author> authors = new ArrayList<>();

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

    /**
     * Creates a new {@code Title}.
     *
     * @param id      the id used for the initialization.
     * @param name    the name used for the initialization.
     * @param authors the list of authors used for the initialization.
     */
    public Title(Integer id, String name, List<Author> authors) {
        this.id = id;
        this.name = name;
        this.authors = authors;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title title = (Title) o;
        return Objects.equals(getId(), title.getId()) && Objects.equals(getName(), title.getName()) && Objects.equals(authors, title.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), authors);
    }
}