package com.teamProject.tripPlan.dao;

import com.teamProject.tripPlan.dto.MbtiQuestionDTO;
import com.teamProject.tripPlan.entity.MbtiQuestion;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Transactional
public class MbtiQuestionDAO {

    @Autowired
    EntityManager em;

    public MbtiQuestion findById(Long questionId) {
       MbtiQuestion mbtiQuestion = em.find(MbtiQuestion.class, questionId);
       return mbtiQuestion;
    }

    public List<MbtiQuestion> findAll() {
        String sql = "SELECT q FROM MbtiQuestion q";
        List<MbtiQuestion> mbtiQuestion = em.createQuery(sql).getResultList();
        return mbtiQuestion;
    }

}
