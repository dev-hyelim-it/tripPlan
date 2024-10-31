package com.teamProject.tripPlan.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Suggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long suggestionId;
    @Column(length = 500)
    private String suggestionTitle;
    @Column(length = 1000)
    private String suggestionContent;
    private LocalDateTime suggestionDate;
//    @Column(length = 1000)
//    private String msgForNormalPerson;
//
//    public Suggestion() {
//        this.msgForNormalPerson = "작성자와 관리자만 확인 가능한 메모입니다.";
//    }


    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "suggestion",
            cascade = {CascadeType.PERSIST,
                    CascadeType.REMOVE})
    private List<Comment> comments = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_no")
    private Users users;
}
