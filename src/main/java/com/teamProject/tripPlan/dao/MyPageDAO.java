package com.teamProject.tripPlan.dao;

import com.teamProject.tripPlan.dto.UsersDTO;
import com.teamProject.tripPlan.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class MyPageDAO {
    @Autowired
    EntityManager em;

    public Users getOneUser(Long id) {
        Users users = em.find(Users.class, id);
        return users;
    }

    public Post getUserPost(Long id) {
        Post post = em.find(Post.class, id);
        return post;
    }

    public void updateInfo(UsersDTO dto) {
        Users users = em.find(Users.class, dto.getUserNo());
        users.setUserId(dto.getUserId());
        users.setUserName(dto.getUserName());
        users.setUserNickname(dto.getUserNickname());
        users.setUserEmail(dto.getUserEmail());
    }

    public void deleteInfo(Long id) {
        Users users = em.find(Users.class, id);
        em.remove(users);
    }

    // 유저에 해당하는 여행 계획 리스트 가져오기 (키워드, 지역, 날짜)
    public List<Travel> findUserList(Long id) {
        Long id1 = 1L;
        String sql = "SELECT t FROM Travel t " +
                "JOIN t.users u " +
                "WHERE u.userNo = " + id1;
        Query query = em.createQuery(sql);
        List<Travel> travels = query.getResultList();
//        for (Travel travel : travels) {
//            System.out.println(travel.getPlace());
//        }
        return travels;
    }

    // 해당 유저의 여행 계획 리스트 가져오기 (숙소)
    public List<Accommodation> findUserAccommodation(Long id) {
        Long id1 = 1L;
        String sql = "SELECT a FROM Accommodation a " +
                "JOIN TravelAccommodation ta " +
                "ON a.accommodationId = ta.accommodation.accommodationId " +
                "JOIN ta.travel t " +
                "ON ta.travel.travelId = " + id1;
        Query query = em.createQuery(sql);
        List<Accommodation> accommodation = query.getResultList();
        for (Accommodation accommodation1 : accommodation) {
            System.out.println(accommodation1.getAccommodationId()+accommodation1.getAccommodationName());
        }
        return accommodation;
    }
}
