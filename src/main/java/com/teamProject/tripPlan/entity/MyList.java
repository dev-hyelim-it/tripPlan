package com.teamProject.tripPlan.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MyList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long myListId;
    private String placeName;
    private String placeAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "travel_id")
    private Travel travel;

    public MyList(String placeName, String addressName) {}

    public void setTravelId(Long travelId) {
    }
}