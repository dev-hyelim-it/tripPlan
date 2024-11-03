package com.teamProject.tripPlan.dao;

import com.teamProject.tripPlan.dto.PostDTO;
import com.teamProject.tripPlan.dto.SuggestionDTO;
import com.teamProject.tripPlan.entity.Post;
import com.teamProject.tripPlan.entity.Suggestion;
import com.teamProject.tripPlan.entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Component
@Transactional
public class SuggestionDAO {

    @Autowired
    EntityManager em;

    public void insertSuggestion(Long userNo, Suggestion suggestion) {
        Users users = em.find(Users.class, userNo);
        suggestion.setUsers(users);
        users.getSuggestions().add(suggestion);
        em.persist(users);
    }

    public List<Suggestion> findAllSuggestion() {
        String sql = "SELECT s FROM Suggestion s ORDER BY s.suggestionId DESC";
        List<Suggestion> suggestions = em.createQuery(sql).getResultList();
        return suggestions;
    }

    public Suggestion getOneSuggestion(Long suggestionId) {
        Suggestion suggestion = em.find(Suggestion.class, suggestionId);
        return suggestion;
    }

    public void deleteById(Long suggestionId) {
        Suggestion suggestion = em.find(Suggestion.class, suggestionId);
        em.remove(suggestion);
    }

    public void updateSuggestion(SuggestionDTO dto) {
        Suggestion suggestion = em.find(Suggestion.class, dto.getSuggestionId());
        suggestion.setSuggestionTitle(dto.getSuggestionTitle());
        suggestion.setSuggestionContent(dto.getSuggestionContent());
//        em.persist(post);
    }
}