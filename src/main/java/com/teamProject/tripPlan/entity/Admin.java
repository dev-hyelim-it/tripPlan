package com.teamProject.tripPlan.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminNo;
    @Column(nullable = false, length = 30)
    private String adminId;
    @Column(nullable = false, length = 20)
    private String adminPw;
    @Column(nullable = false, length = 20)
    private String adminName;



}
