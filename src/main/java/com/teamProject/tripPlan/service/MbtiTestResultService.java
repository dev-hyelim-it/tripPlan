package com.teamProject.tripPlan.service;

import com.teamProject.tripPlan.dao.MbtiTestResultDAO;
import com.teamProject.tripPlan.entity.MbtiTestResult;
import com.teamProject.tripPlan.entity.ResultType;
import com.teamProject.tripPlan.repository.MbtiTestResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MbtiTestResultService {

    @Autowired
    MbtiTestResultDAO mbtiTestResultDAO;

    public List<MbtiTestResult> findAll() {
        return mbtiTestResultDAO.findAll();
    }

    public MbtiTestResult findByResultType(ResultType myResult) {
        return mbtiTestResultDAO.findByMyResult(myResult);
//        return null;
    }

}
