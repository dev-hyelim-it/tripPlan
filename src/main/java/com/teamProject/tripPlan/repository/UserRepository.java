package com.teamProject.tripPlan.repository;

import com.teamProject.tripPlan.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    @Query(value = "SELECT * FROM users WHERE user_id LIKE %:userId%", nativeQuery = true)
    Optional<Users> findByUserId(@Param("userId") String userId);
}
