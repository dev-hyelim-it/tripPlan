package com.teamProject.tripPlan.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter

public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;
    @Column(nullable = false, length = 30)
    private String userId;
    @Column(nullable = false, length = 30)
    private String userPassword;
    @Column(nullable = false, length = 20)
    private String userName;
    private String userNickname;
    @Column(nullable = false, length = 30)
    private String userEmail;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "users",
            cascade = CascadeType.PERSIST)
    List<Post> posts = new ArrayList<>();
}
