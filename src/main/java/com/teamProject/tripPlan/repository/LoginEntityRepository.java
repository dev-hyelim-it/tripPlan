package com.teamProject.tripPlan.repository;

import com.teamProject.tripPlan.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface LoginEntityRepository extends JpaRepository<Users, String> {

    Boolean existsByUserEmail(String userEmail);

    Users findByUserEmail(String userEmail);

}
