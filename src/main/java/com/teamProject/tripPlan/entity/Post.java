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
    @Column(nullable = false, length = 50)
    private String postTitle;
    @Column(nullable = false, length = 1000)
    private String postContent;
    @Column(nullable = false)
    private LocalDateTime postDate;


    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "post",
            cascade = {CascadeType.PERSIST,
                    CascadeType.REMOVE})
    List<Comment> comments = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;

}
