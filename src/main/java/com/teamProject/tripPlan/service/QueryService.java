package com.teamProject.tripPlan.service;

import com.teamProject.tripPlan.dto.PostDTO;
import com.teamProject.tripPlan.entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class QueryService {

    @Autowired
    EntityManager em;

    public Users findOneUser(String userId) {
        String sql = "SELECT u FROM Users u WHERE u.userId = :userId";

        TypedQuery<Users> query = em.createQuery(sql, Users.class).setParameter("userId", userId);
        Users users = query.getSingleResult();
//        Query query = em.createQuery(sql).setParameter("id", id);
        return users;
    }
}
