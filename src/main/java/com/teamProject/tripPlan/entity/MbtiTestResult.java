package com.teamProject.tripPlan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MbtiTestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resultId;

    private String resultTitle;

    @Enumerated(EnumType.STRING)
    private ResultType resultType;

    @Column(length = 2000)
    private String description;

    private String recommendArea1;
    private String areaName1;
    @Column(length = 2000)
    private String areaDescription1;

    private String recommendArea2;
    private String areaName2;
    @Column(length = 2000)
    private String areaDescription2;

}
