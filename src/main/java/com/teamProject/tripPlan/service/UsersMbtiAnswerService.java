package com.teamProject.tripPlan.service;

import com.teamProject.tripPlan.dao.UsersMbtiAnswerDAO;
import com.teamProject.tripPlan.dto.UsersMbtiAnswerDTO;
import com.teamProject.tripPlan.entity.UsersMbtiAnswer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UsersMbtiAnswerService {

    @Autowired
    UsersMbtiAnswerDAO usersMbtiAnswerDAO;

    public void insertAnswer(Long userNo, Long questionId, Long optionId) {
        usersMbtiAnswerDAO.insertAnswer(userNo, questionId, optionId);
    }

//    public UsersMbtiAnswer findById(Long questionId) {
//        return usersMbtiAnswerDAO.findById(questionId);
//    }

    public List<UsersMbtiAnswer> findByUserNo(Long userNo) {
        return usersMbtiAnswerDAO.findByUserNo(userNo);
    }

    public void deleteByUserNo(Long userNo) {
        usersMbtiAnswerDAO.deleteByUserNo(userNo);

    }
}
