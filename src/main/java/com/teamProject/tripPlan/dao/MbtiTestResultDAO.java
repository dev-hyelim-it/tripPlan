package com.teamProject.tripPlan.dao;

import com.teamProject.tripPlan.entity.MbtiQuestion;
import com.teamProject.tripPlan.entity.MbtiTestResult;
import com.teamProject.tripPlan.entity.ResultType;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Transactional
public class MbtiTestResultDAO {

    @Autowired
    EntityManager em;

    public List<MbtiTestResult> findAll() {
        String sql = "SELECT mtr FROM MbtiTestResult mtr";

        List<MbtiTestResult> mbtiTestResult = em.createQuery(sql).getResultList();
        return mbtiTestResult;
    }

    public MbtiTestResult findByMyResult(ResultType myResult) {
        String sql = "SELECT mtr FROM MbtiTestResult mtr WHERE mtr.resultType = :resultType";

        MbtiTestResult mbtiTestResult = em.createQuery(sql, MbtiTestResult.class)
                .setParameter("resultType", myResult)
                .getSingleResult();
        return mbtiTestResult;
    }

}
