package com.teamProject.tripPlan.dao;

import com.teamProject.tripPlan.dto.UsersMbtiAnswerDTO;
import com.teamProject.tripPlan.entity.AnswerOptions;
import com.teamProject.tripPlan.entity.MbtiQuestion;
import com.teamProject.tripPlan.entity.Users;
import com.teamProject.tripPlan.entity.UsersMbtiAnswer;
import com.teamProject.tripPlan.service.UsersMbtiAnswerService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Transactional
public class UsersMbtiAnswerDAO {

    @Autowired
    EntityManager em;

    public void insertAnswer(Long userNo, Long questionId, Long optionId) {
        // EntityManager를 통해 엔티티 객체를 조회
        Users user = em.find(Users.class, userNo);
        MbtiQuestion question = em.find(MbtiQuestion.class, questionId);
        AnswerOptions option = em.find(AnswerOptions.class, optionId);

        // 엔티티 필드에 값 설정
        UsersMbtiAnswer usersMbtiAnswer = new UsersMbtiAnswer();
        usersMbtiAnswer.setUsers(user);
        usersMbtiAnswer.setMbtiQuestion(question);
        usersMbtiAnswer.setAnswerOptions(option);

        em.persist(usersMbtiAnswer);
    }

//    public UsersMbtiAnswer findById(Long questionId) {
//        UsersMbtiAnswer usersMbtiAnswer = em.find(UsersMbtiAnswer.class, questionId);
//        return usersMbtiAnswer;
//    }

    public List<UsersMbtiAnswer> findByUserNo(Long userNo) {
        String sql = "SELECT uma FROM UsersMbtiAnswer uma WHERE uma.users.userNo = :userNo";
        return em.createQuery(sql, UsersMbtiAnswer.class).setParameter("userNo", userNo).getResultList();
    }

}
