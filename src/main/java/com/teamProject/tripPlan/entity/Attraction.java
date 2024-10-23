package com.teamProject.tripPlan.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Attraction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attractionId;
    @Column(nullable = false, length = 300)
    private String attractionName;
    @Column(nullable = false, length = 300)
    private String attractionLocation;
    @Column(length = 20)
    private String keyword;


    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "attraction",
            cascade = CascadeType.PERSIST)
    List<TravelAttraction> travelAttractions = new ArrayList<>();
}
