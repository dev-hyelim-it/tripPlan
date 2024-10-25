package com.teamProject.tripPlan.dao;

import com.teamProject.tripPlan.dto.KeywordDTO;
import com.teamProject.tripPlan.entity.Keyword;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class KeywordDAO {

    @Autowired
    EntityManager em;

    public void insertKeyword(Keyword keyword) {
        em.persist(keyword);
    }

    public void deleteKeyword(Long keywordId) {
        Keyword keywordOne = em.find(Keyword.class, keywordId);
        em.remove(keywordOne);
    }



}