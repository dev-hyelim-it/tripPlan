package com.teamProject.tripPlan.repository;

import com.teamProject.tripPlan.entity.MyList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyListRepository extends JpaRepository<MyList, Long> {
}