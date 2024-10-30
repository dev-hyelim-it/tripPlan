package com.teamProject.tripPlan.service;

import com.teamProject.tripPlan.dao.MbtiQuestionDAO;
import com.teamProject.tripPlan.dto.MbtiQuestionDTO;
import com.teamProject.tripPlan.entity.MbtiQuestion;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    @Autowired
    MbtiQuestionDAO questionDAO;

    public List<MbtiQuestionDTO> findAll() {
        List<MbtiQuestionDTO> dtos = questionDAO.findAll().stream().map(x->MbtiQuestionDTO.fromEntity(x)).toList();
        return dtos;
    }

    public MbtiQuestion findById(Long questionId) {
        return questionDAO.findById(questionId);
    }


}
