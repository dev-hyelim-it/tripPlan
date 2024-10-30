package com.teamProject.tripPlan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MbtiQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @Column(length = 500)
    private String questionText;

    @Column(length = 500)
    private String questionType;

    @OneToMany(mappedBy = "mbtiQuestion",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<UsersMbtiAnswer> usersMbtiAnswers = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "mbtiQuestion",
            cascade = CascadeType.PERSIST)
    private List<AnswerOptions> answerOptions = new ArrayList<>();

}
