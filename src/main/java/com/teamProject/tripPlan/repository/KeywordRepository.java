package com.teamProject.tripPlan.repository;

import com.teamProject.tripPlan.entity.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//sg1
public interface KeywordRepository extends JpaRepository<Keyword, String> {

}
