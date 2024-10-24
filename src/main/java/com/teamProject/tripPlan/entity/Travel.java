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
    private String place;
    private LocalDateTime startDate;
    private LocalDateTime endDate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;


    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "travel",
            cascade = CascadeType.PERSIST)
    List<TravelRestaurant> travelRestaurants = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "travel",
            cascade = CascadeType.PERSIST)
    List<TravelAttraction> travelAttractions = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "travel",
            cascade = CascadeType.PERSIST)
    List<TravelAccommodation> travelAccommodations = new ArrayList<>();





    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "travel_id")
    private Post post;
}
