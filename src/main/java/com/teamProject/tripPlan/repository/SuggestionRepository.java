package com.teamProject.tripPlan.repository;

import com.teamProject.tripPlan.entity.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {
}
