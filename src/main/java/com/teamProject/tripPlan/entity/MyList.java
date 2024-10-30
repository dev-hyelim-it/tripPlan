package com.teamProject.tripPlan.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class MyList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가 설정
    private Long listId; // 식별자 필드

    private String placeName;
    private String placeAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    private Travel travel;

    // Getters and Setters (필요시 추가)
}