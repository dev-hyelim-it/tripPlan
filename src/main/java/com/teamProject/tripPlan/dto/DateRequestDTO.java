package com.teamProject.tripPlan.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DateRequestDTO {
    private List<MyListDTO> places;  // 장소 정보 배열
    private TravelDatesDTO travelDates;  // 날짜 정보
}
