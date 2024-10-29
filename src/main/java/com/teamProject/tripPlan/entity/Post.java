package com.teamProject.tripPlan.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    @Column(length = 500)
    private String postTitle;
    @Column(length = 1000)
    private String postContent;
    private LocalDateTime postDate;
    private int likes;

    public Post() {
        this.likes = 0;
    }

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "post",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Comment> comments = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_no")
    private Users users;

    @OneToOne(mappedBy = "post", fetch = FetchType.LAZY)
    private Travel travel;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "post_keyword",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "keyword_id")
    )
    private List<Keyword> keywords = new ArrayList<>();
}
