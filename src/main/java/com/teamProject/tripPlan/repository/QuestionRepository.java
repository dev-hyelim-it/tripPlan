package com.teamProject.tripPlan.repository;

import com.teamProject.tripPlan.entity.MbtiQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<MbtiQuestion, Long> {
}
