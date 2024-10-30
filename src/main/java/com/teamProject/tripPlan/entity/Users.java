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
    @Column(nullable = false, length = 30, unique = true)
    private String userPassword;
    @Column(nullable = false, length = 20)
    private String userName;
    @Column(nullable = false, length = 30, unique = true)
    private String userNickname;
    @Column(nullable = false, length = 30, unique = true)
    private String userEmail;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "users",
            cascade = CascadeType.PERSIST)
    private List<Post> posts = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "users",
            cascade = CascadeType.PERSIST)
    private List<Suggestion> suggestions = new ArrayList<>();

    @OneToMany(mappedBy = "users",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY)
    private List<UsersMbtiAnswer> usersMbtiAnswer = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private ResultType resultType;

}
