package com.teamProject.tripPlan.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accommodationId;
    @Column(nullable = false, length = 300)
    private String accommodationName;
    @Column(nullable = false, length = 300)
    private String accommodationLocation;
    @Column(length = 20)
    private String keyword;
    @Column(length = 20)
    private String accommodationGrade;
    @Column(length = 20)
    private String accommodationCall;


    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "accommodation",
            cascade = CascadeType.PERSIST)
    List<TravelAccommodation> travelAccommodations = new ArrayList<>();


}
