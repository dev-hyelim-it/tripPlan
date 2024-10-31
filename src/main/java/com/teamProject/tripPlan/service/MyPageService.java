package com.teamProject.tripPlan.service;

import com.teamProject.tripPlan.dao.MyPageDAO;
import com.teamProject.tripPlan.dto.PostDTO;
import com.teamProject.tripPlan.dto.UsersDTO;
import com.teamProject.tripPlan.entity.*;
import com.teamProject.tripPlan.repository.MyListRepository;
import com.teamProject.tripPlan.repository.PostRepository;
import com.teamProject.tripPlan.repository.TravelDateRepository;
import com.teamProject.tripPlan.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyPageService {
    @Autowired
    MyPageDAO myPageDAO;
    @Autowired
    TravelDateRepository travelDateRepository;
    @Autowired
    MyListRepository myListRepository;

    public UsersDTO findLoginUser(Long id) {
        Users users = myPageDAO.getOneUser(id);
        return UsersDTO.fromEntity(users);
    }

    public UsersDTO updateInfo(UsersDTO dto) {
        Users users = myPageDAO.updateInfo(dto);
        return UsersDTO.fromEntity(users);
    }

    public void deleteInfo(Long id) {
        myPageDAO.deleteInfo(id);
    }

    public List<Travel> findUserList(Long id) {
        List<Travel> travels = myPageDAO.findUserList(id);
        return travels;
    }

    public Long findUserId(String userId) {
        Long id = myPageDAO.findUserId(userId);
        return id;
    }

    // 트래블 데이터 저장 테스트용
    public TravelDates insertDate(TravelDates dates) {
        TravelDates dates1 = new TravelDates();
        dates1.setDeparture_date(dates.getDeparture_date());
        dates1.setArrival_date(dates.getArrival_date());
        travelDateRepository.save(dates1);
        return dates1;
    }

    public List<MyList> findAllMyLists(){
        return myListRepository.findAll();
    }
}