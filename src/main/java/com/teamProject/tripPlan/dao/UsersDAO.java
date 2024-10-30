package com.teamProject.tripPlan.dao;

import com.teamProject.tripPlan.entity.Keyword;
import com.teamProject.tripPlan.entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class UsersDAO {

    @Autowired
    EntityManager em;

    public void deleteUser(Long userNo) {
        Users user = em.find(Users.class, userNo);
        em.remove(user);
    }

}
