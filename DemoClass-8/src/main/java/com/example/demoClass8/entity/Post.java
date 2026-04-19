package com.example.demoClass8.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private LocalDate date;

    //just as the name of the class (post) - (Post)
    //recommended to use FetchType.Eager
    //.Lazy is better for performance
    //gi fetcira komentarite
    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<PostComment> postComments;

    public Post() {
    }

    public Post(String text, LocalDate date, List<PostComment> postComments) {
        this.text = text;
        this.date = date;
        this.postComments = postComments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<PostComment> getPostComments() {
        return postComments;
    }

    public void setPostComments(List<PostComment> postComments) {
        this.postComments = postComments;
    }
}
