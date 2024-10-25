package com.teamProject.tripPlan.dao;

import com.teamProject.tripPlan.dto.UsersDTO;
import com.teamProject.tripPlan.entity.Post;
import com.teamProject.tripPlan.entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
