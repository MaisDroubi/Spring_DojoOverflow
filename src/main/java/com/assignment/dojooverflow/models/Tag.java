package com.assignment.dojooverflow.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tags_questions",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private List<Question> question;

    public Tag() {
    }

    public Tag(String subject) {
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Question> getQuestion() {
        return question;
    }

    public void setQuestion(List<Question> question) {
        this.question = question;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }
    @PostPersist
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
    public String[] splitTags() {
        return this.subject.split("\\s*,\\s*");
    }
}
