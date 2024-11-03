package com.teamProject.tripPlan.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    @Column(length = 500)
    private String postTitle;
    @Column(length = 1000)
    private String postContent;
    private int likes;

    public Post() {
        this.likes = 0;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Comment> comments = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_no")
    private Users users;

    @OneToOne(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Travel travel;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "keyword_id")
    private Keyword keyword;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post", cascade = CascadeType.PERSIST)
    private List<Place> places = new ArrayList<>(); // 장소 리스트 추가
}