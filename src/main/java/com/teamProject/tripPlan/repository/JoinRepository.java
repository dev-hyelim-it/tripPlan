package com.teamProject.tripPlan.repository;

import com.teamProject.tripPlan.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoinRepository extends JpaRepository<Users, String> {
    // 기존 아이디와 비교
    boolean existsByUserId(String userId);

    // 기존 닉네임과 비교
    boolean existsByUserNickname(String userNickname);

    // 기존 이메일과 비교
    boolean existsByUserEmail(String userEmail);

    // userId로 사용자 찾기
    Users findByUserId(String userId);
}
