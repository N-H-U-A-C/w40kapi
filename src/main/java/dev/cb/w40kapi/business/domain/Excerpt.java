package dev.cb.w40kapi.business.domain;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * Class that models an excerpt. An excerpt has an id and a name.
 *
 * @author N.H.U.A.C
 * @version 1.0
 */
@Entity
@Table(name = "EXCERPTS")
public class Excerpt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EXCERPT")
    private Integer id;
    @Column(name = "TITLE_EXCERPT")
    private String title;
    @Column(name = "CONTENT")
    private String content;
    @Column(name = "CONTEXT")
    private String context;

    @ManyToOne
    @JoinColumn(name = "ID_AUTHOR")
    private Author author;

    /**
     * Creates a new {@code Excerpt}.
     */
    protected Excerpt() {
    }

    /**
     * Creates a new {@code Excerpt}
     *
     * @param id      the id used for the initialization.
     * @param title   the title used for the initialization.
     * @param content the content used for the initialization.
     * @param context the context used for the initialization.
     */
    public Excerpt(Integer id, String title, String content, String context) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.context = context;
    }

    /**
     * Creates a new {@code Excerpt}
     *
     * @param id      the id used for the initialization.
     * @param title   the title used for the initialization.
     * @param content the content used for the initialization.
     * @param context the context used for the initialization.
     * @param author  the author used for the initialization.
     */
    public Excerpt(Integer id, String title, String content, String context, Author author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.context = context;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getContext() {
        return context;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Excerpt excerpt = (Excerpt) o;
        return Objects.equals(getId(), excerpt.getId()) && Objects.equals(getTitle(), excerpt.getTitle()) && Objects.equals(getContent(), excerpt.getContent()) && Objects.equals(getContext(), excerpt.getContext()) && Objects.equals(getAuthor(), excerpt.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getContent(), getContext(), getAuthor());
    }

    @Override
    public String toString() {
        return "Excerpt{" +
               "id=" + id +
               ", title='" + title + '\'' +
               ", content='" + content + '\'' +
               ", context='" + context + '\'' +
               ", author=" + author +
               '}';
    }
}