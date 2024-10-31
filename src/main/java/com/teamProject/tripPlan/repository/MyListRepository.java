package com.teamProject.tripPlan.repository;

import com.teamProject.tripPlan.entity.MyList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyListRepository extends JpaRepository<MyList, Long> {

    @Query("SELECT m.placeName, COUNT(m.placeName) AS placeCount " +
            "FROM MyList m " +
            "GROUP BY m.placeName " +
            "ORDER BY placeCount DESC")
    List<Object[]> findTop5Places();

}