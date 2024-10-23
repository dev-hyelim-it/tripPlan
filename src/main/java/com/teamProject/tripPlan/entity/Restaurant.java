package com.teamProject.tripPlan.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantId;
    @Column(nullable = false, length = 300)
    private String restaurantName;
    @Column(nullable = false, length = 300)
    private String restaurantLocation;
    @Column(length = 20)
    private String keyword;





    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "restaurant",
            cascade = CascadeType.PERSIST)
    List<TravelRestaurant> travelRestaurants = new ArrayList<>();
}
