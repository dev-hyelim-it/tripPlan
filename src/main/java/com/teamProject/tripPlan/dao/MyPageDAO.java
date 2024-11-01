package com.teamProject.tripPlan.dao;

import com.teamProject.tripPlan.dto.UsersDTO;
import com.teamProject.tripPlan.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Transactional
public class MyPageDAO {
    @Autowired
    EntityManager em;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public Users getOneUser(Long id) {
        Users users = em.find(Users.class, id);
        return users;
    }

    public Post getUserPost(Long id) {
        Post post = em.find(Post.class, id);
        return post;
    }

    public Users updateInfo(UsersDTO dto) {
        Users users = em.find(Users.class, dto.getUserNo());
        users.setUserId(dto.getUserId());
        users.setUserPassword(bCryptPasswordEncoder.encode(dto.getUserPassword()));
        users.setUserName(dto.getUserName());
        users.setUserNickname(dto.getUserNickname());
        users.setUserEmail(dto.getUserEmail());
        return users;
    }

    public void deleteInfo(Long id) {
        Users users = em.find(Users.class, id);
        em.remove(users);
    }

    // 유저 id로 유저 no 가져오기
    public Long findUserId(String userId) {
        String sql = "SELECT u FROM Users u " +
                "WHERE u.userId = '" + userId + "'";
        Query query = em.createQuery(sql);
        Users users = (Users) query.getSingleResult();
        Long id = users.getUserNo();
        System.out.println(id);
        return id;
    }

    // 유저에 해당하는 Travel 리스트 가져오기
    public List<Travel> findUserList(Long id) {
        String sql = "SELECT t FROM Travel t " +
                "JOIN t.users u " +
                "WHERE u.userNo = " + id;
        Query query = em.createQuery(sql);
        List<Travel> travels = query.getResultList();
        return travels;
    }

    // 해당 유저의 여행 계획 리스트 가져오기 (숙소)
    public List<Accommodation> findUserAccommodation(Long id) {
        String sql = "SELECT a FROM Accommodation a " +
                "JOIN TravelAccommodation ta " +
                "ON a.accommodationId = ta.accommodation.accommodationId " +
                "JOIN ta.travel t " +
                "ON ta.travel.travelId = " + id;
        Query query = em.createQuery(sql);
        List<Accommodation> accommodation = query.getResultList();
        return accommodation;
    }


    public List<Place> findPlace(Long travelId) {
        String sql = "SELECT p FROM Place p " +
                "JOIN p.travel t " +
                "WHERE t.travelId = " + travelId;
        Query query = em.createQuery(sql);
        List<Place> places = query.getResultList();
        return places;
    }
}