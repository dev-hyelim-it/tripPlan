package com.teamProject.tripPlan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
public class MainDTO {
    private String keyword;
    private String area;
    private int travelId;
    private Date departureDate;
    private Date arrivalDate;

    public MainDTO(String keyword, String area, int travelId, Date departureDate, Date arrivalDate) {
        this.keyword = keyword;
        this.area = area;
        this.travelId = travelId;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    // Getters and Setters
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getTravelId() {
        return travelId;
    }

    public void setTravelId(int travelId) {
        this.travelId = travelId;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
}