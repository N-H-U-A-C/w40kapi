package dev.cb.w40kapi.business.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class that models an excerpt. An excerpt has an id, a content and at least one {@code ExcerptSource}, and can have a header, a context, an {@code Author}, multiple {@code Category} and others {@code ExcerptSource}.
 *
 * @author N.H.U.A.C
 * @version 1.0
 * @see Author
 * @see Category
 * @see ExcerptSource
 */
@Entity
@Table(name = "EXCERPTS")
public class Excerpt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EXCERPT")
    private Integer id;
    @Column(name = "HEADER")
    private String header;
    @Column(name = "CONTENT")
    private String content;
    @Column(name = "CONTEXT")
    private String context;

    @ManyToOne
    @JoinColumn(name = "ID_AUTHOR")
    private Author author;

    @ManyToMany
    @JoinTable(name = "CATEGORIZE",
            joinColumns = @JoinColumn(name = "ID_EXCERPT"),
            inverseJoinColumns = @JoinColumn(name = "ID_CATEGORY"))
    private List<Category> categories = new ArrayList<>();

    @OneToMany(mappedBy = "excerpt")
    @JsonManagedReference
    private List<ExcerptSource> excerptSources = new ArrayList<>();

    /**
     * Creates a new {@code Excerpt}.
     */
    protected Excerpt() {
    }

    /**
     * Creates a new {@code Excerpt}
     *
     * @param id      the id used for the initialization.
     * @param header  the header used for the initialization.
     * @param content the content used for the initialization.
     * @param context the context used for the initialization.
     */
    public Excerpt(Integer id, String header, String content, String context) {
        this.id = id;
        this.header = header;
        this.content = content;
        this.context = context;
    }

    /**
     * Creates a new {@code Excerpt}
     *
     * @param id      the id used for the initialization.
     * @param header  the header used for the initialization.
     * @param content the content used for the initialization.
     * @param context the context used for the initialization.
     * @param author  the author used for the initialization.
     */
    public Excerpt(Integer id, String header, String content, String context, Author author) {
        this.id = id;
        this.header = header;
        this.content = content;
        this.context = context;
        this.author = author;
    }

    /**
     * Creates a new {@code Excerpt}
     *
     * @param id         the id used for the initialization.
     * @param header     the header used for the initialization.
     * @param content    the content used for the initialization.
     * @param context    the context used for the initialization.
     * @param author     the author used for the initialization.
     * @param categories the categories used for the initialization.
     */
    public Excerpt(Integer id, String header, String content, String context, Author author, List<Category> categories) {
        this.id = id;
        this.header = header;
        this.content = content;
        this.context = context;
        this.author = author;
        this.categories = categories;
    }

    /**
     * Creates a new {@code Excerpt}
     *
     * @param id             the id used for the initialization.
     * @param header         the header used for the initialization.
     * @param content        the content used for the initialization.
     * @param context        the context used for the initialization.
     * @param author         the author used for the initialization.
     * @param categories     the categories used for the initialization.
     * @param excerptSources the excerptSources used for the initialization.
     */
    public Excerpt(Integer id, String header, String content, String context, Author author, List<Category> categories, List<ExcerptSource> excerptSources) {
        this.id = id;
        this.header = header;
        this.content = content;
        this.context = context;
        this.author = author;
        this.categories = categories;
        this.excerptSources = excerptSources;
    }

    public Integer getId() {
        return id;
    }

    public String getHeader() {
        return header;
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

    public List<Category> getCategories() {
        return categories;
    }

    public List<ExcerptSource> getExcerptSources() {
        return excerptSources;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Excerpt excerpt = (Excerpt) o;
        return Objects.equals(getId(), excerpt.getId()) && Objects.equals(getHeader(), excerpt.getHeader()) && Objects.equals(getContent(), excerpt.getContent()) && Objects.equals(getContext(), excerpt.getContext()) && Objects.equals(getAuthor(), excerpt.getAuthor()) && Objects.equals(getCategories(), excerpt.getCategories()) && Objects.equals(getExcerptSources(), excerpt.getExcerptSources());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getHeader(), getContent(), getContext(), getAuthor(), getCategories(), getExcerptSources());
    }

    @Override
    public String toString() {
        return "Excerpt{" +
               "id=" + id +
               ", header='" + header + '\'' +
               ", content='" + content + '\'' +
               ", context='" + context + '\'' +
               ", author=" + author +
               ", categories=" + categories +
               ", excerptSources=" + excerptSources +
               '}';
    }
}