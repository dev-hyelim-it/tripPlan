package com.teamProject.tripPlan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
//sg1
//Getter, Setter || Data 다 오류나길래 일단 모든 entity 다 getter, setter 적었어요..!
@Entity
public class Keyword {
    @Id
    private String keyword;

    public Keyword() {}

    public Keyword(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

}
