package com.teamProject.tripPlan.repository;

import com.teamProject.tripPlan.entity.TravelDates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelDateRepository extends JpaRepository<TravelDates, Long> {
}
