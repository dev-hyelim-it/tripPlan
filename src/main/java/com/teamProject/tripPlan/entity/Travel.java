package com.teamProject.tripPlan.entity;

import jakarta.persistence.*;
import lombok.*;

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

    private String accommodation; // 이용한 숙소
    private String restaurant; // 이용한 식당
    private String attractions; // 관광지

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

//    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "MyList", fetch = FetchType.LAZY)
//    List<MyList> myLists = new ArrayList<>();
}
