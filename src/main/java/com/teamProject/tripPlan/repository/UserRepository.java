package com.teamProject.tripPlan.repository;

import com.teamProject.tripPlan.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
