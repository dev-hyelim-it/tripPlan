package com.teamProject.tripPlan.repository;

import com.teamProject.tripPlan.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepository extends JpaRepository<Post, Long> {

}