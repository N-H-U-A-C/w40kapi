package dev.cb.w40kapi.business.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Class that models the many-to-many associative table between {@code Excerpt} and {@code Source}. An excerptSource have an {@code ExcerptSourceId} (composite primary key), an {@code Excerpt} and a {@code Source}, and can have a page.
 *
 * @author N.H.U.A.C
 * @version 1.0
 * @see ExcerptSourceId
 * @see Excerpt
 * @see Source
 */
@Entity
@Table(name = "include")
public class ExcerptSource {

    @EmbeddedId
    private ExcerptSourceId id = new ExcerptSourceId();
    private Short page;

    @ManyToOne
    @JoinColumn(name = "id_excerpt")
    @MapsId("excerptId")
    @JsonBackReference
    private Excerpt excerpt;

    @ManyToOne
    @JoinColumn(name = "id_source")
    @MapsId("sourceId")
    private Source source;

    protected ExcerptSource() {
    }

    /**
     * Creates a new {@code ExcerptSource}
     *
     * @param id     the composite primary key used for the initialization.
     * @param page   the page used for the initialization.
     * @param source the source used for the initialization.
     */
    public ExcerptSource(ExcerptSourceId id, Short page, Source source) {
        this.id = id;
        this.page = page;
        this.source = source;
    }

    /**
     * Creates a new {@code ExcerptSource}
     *
     * @param id      the composite primary key used for the initialization.
     * @param page    the page used for the initialization.
     * @param excerpt the excerpt used for the initialization.
     * @param source  the source used for the initialization.
     */
    public ExcerptSource(ExcerptSourceId id, Short page, Excerpt excerpt, Source source) {
        this.id = id;
        this.page = page;
        this.excerpt = excerpt;
        this.source = source;
    }

    public ExcerptSourceId getId() {
        return id;
    }

    public Short getPage() {
        return page;
    }

    public Excerpt getExcerpt() {
        return excerpt;
    }

    public Source getSource() {
        return source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExcerptSource that = (ExcerptSource) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getPage(), that.getPage()) && Objects.equals(getExcerpt(), that.getExcerpt()) && Objects.equals(getSource(), that.getSource());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPage(), getExcerpt(), getSource());
    }

    @Override
    public String toString() {
        return "ExcerptSource{" +
               "id=" + id +
               ", page=" + page +
               ", excerpt=" + excerpt +
               ", source=" + source +
               '}';
    }

    /**
     * Class that models the composite primary key of an {@code ExcerptSource} (many-to-many associative table). An excerptSourceId has an {@code Excerpt} id and a {@code Source} id.
     *
     * @author N.H.U.A.C
     * @version 1.0
     * @see ExcerptSource
     * @see Excerpt
     * @see Source
     */
    @Embeddable
    public static class ExcerptSourceId implements Serializable {

        private Integer excerptId;
        private Integer sourceId;

        protected ExcerptSourceId() {
        }

        /**
         * Creates a new {@code ExcerptSourceId}
         *
         * @param excerptId the excerpt id used for the initialization.
         * @param sourceId  the source id used for the initialization.
         */
        public ExcerptSourceId(Integer excerptId, Integer sourceId) {
            this.excerptId = excerptId;
            this.sourceId = sourceId;
        }

        public Integer getExcerptId() {
            return excerptId;
        }

        public Integer getSourceId() {
            return sourceId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ExcerptSourceId that = (ExcerptSourceId) o;
            return Objects.equals(getExcerptId(), that.getExcerptId()) && Objects.equals(getSourceId(), that.getSourceId());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getExcerptId(), getSourceId());
        }

        @Override
        public String toString() {
            return "ExcerptSourceId{" +
                   "excerptId=" + excerptId +
                   ", sourceId=" + sourceId +
                   '}';
        }
    }
}