package com.teamProject.tripPlan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Date;
//sg1
@Entity
public class TravelDates {
    @Id
    private int travelId;
    private Date departure_date;
    private Date arrival_date;

    public TravelDates() {}

    public TravelDates(int travelId, Date departureDate, Date arrivalDate) {
        this.travelId = travelId;
        this.departure_date = departureDate;
        this.arrival_date = arrivalDate;
    }

    public int getTravelId() {
        return travelId;
    }

    public void setTravelId(int travelId) {
        this.travelId = travelId;
    }

    public Date getDepartureDate() {
        return departure_date;
    }

    public void setDepartureDate(Date departureDate) {
        this.departure_date = departureDate;
    }

    public Date getArrivalDate() {
        return arrival_date;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrival_date = arrivalDate;
    }
}
