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
public class AnswerOptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long optionId;

    @Column(length = 200)
    private String optionText;

    @Enumerated(EnumType.STRING)
    private OptionType optionType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questionId")
    private MbtiQuestion mbtiQuestion;

    @OneToMany(mappedBy = "answerOptions",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<UsersMbtiAnswer> usersMbtiAnswer = new ArrayList<>();


}
