package dev.cb.w40kapi.business.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "INCLUDE")
public class ExcerptSource {

    @EmbeddedId
    private ExcerptSourceId id = new ExcerptSourceId();
    private Short page;

    @ManyToOne
    @JoinColumn(name = "ID_EXCERPT")
    @MapsId("excerptId")
    @JsonBackReference
    private Excerpt excerpt;

    @ManyToOne
    @JoinColumn(name = "ID_SOURCE")
    @MapsId("sourceId")
    private Source source;

    protected ExcerptSource() {
    }

    public ExcerptSource(ExcerptSourceId id, Short page, Source source) {
        this.id = id;
        this.page = page;
        this.source = source;
    }

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

    @Embeddable
    public static class ExcerptSourceId implements Serializable {

        private Integer excerptId;
        private Integer sourceId;

        protected ExcerptSourceId() {
        }

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