package com.teamProject.tripPlan.dao;

import com.teamProject.tripPlan.dto.UsersDTO;
import com.teamProject.tripPlan.entity.Post;
import com.teamProject.tripPlan.entity.Travel;
import com.teamProject.tripPlan.entity.Users;
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

    public List<Travel> findUserList(Long id) {
        Long id1 = 1L;
        String sql = "SELECT t FROM Travel t " +
                "JOIN t.users u " +
                "WHERE u.userNo = " + id1;
        Query query = em.createQuery(sql);
        List<Travel> travels = query.getResultList();
        return travels;
    }
}
