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
public class Travel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long travelId;
    @Column(length = 20)
    private String keyword;

    private LocalDateTime startPoint;
    private LocalDateTime endPoint;
    private LocalDateTime startDate;
    private LocalDateTime endDate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "travel",
            cascade = {CascadeType.PERSIST,
                    CascadeType.REMOVE})
    List<Restaurant> restaurants = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "travel",
            cascade = {CascadeType.PERSIST,
                    CascadeType.REMOVE})
    List<Attraction> attractions = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "travel",
            cascade = {CascadeType.PERSIST,
                    CascadeType.REMOVE})
    List<Accommodation> accommodations = new ArrayList<>();

}
