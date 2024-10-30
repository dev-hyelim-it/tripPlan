package com.teamProject.tripPlan.service;

import com.teamProject.tripPlan.dao.SuggestionDAO;
import com.teamProject.tripPlan.dto.SuggestionDTO;
import com.teamProject.tripPlan.entity.Suggestion;
import com.teamProject.tripPlan.repository.SuggestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class SuggestionService {

    @Autowired
    SuggestionDAO dao;

    @Autowired
    SuggestionRepository suggestionRepository;

    public List<SuggestionDTO> findAllSuggestion() {
        return dao.findAllSuggestion().stream().map(x->SuggestionDTO.fromEntity(x)).toList();
    }

    public SuggestionDTO getOneSuggestion(Long suggestionId) {
        Suggestion suggestion = dao.getOneSuggestion(suggestionId);
        if (ObjectUtils.isEmpty(suggestion)) {
            return null;
        }
        return SuggestionDTO.fromEntity(suggestion);
    }

    public void deleteSuggestion(Long suggestionId) {
        dao.deleteById(suggestionId);
    }

    public void updateSuggestion(SuggestionDTO dto) {
        dao.updateSuggestion(dto);
    }
}
