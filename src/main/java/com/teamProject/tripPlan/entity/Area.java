package com.teamProject.tripPlan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
public class Area {
    @Id
    private String area;

    public Area() {}
    public Area(String area) {
        this.area = area;
    }
    public String getArea() {
        return area;
    }
    public void setArea() {
        this.area = area;
    }
}
