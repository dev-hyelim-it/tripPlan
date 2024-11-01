package com.teamProject.tripPlan.service;

import com.teamProject.tripPlan.dao.SuggestionCommentDAO;
import com.teamProject.tripPlan.dto.CommentDTO;
import com.teamProject.tripPlan.dto.SuggestionCommentDTO;
import com.teamProject.tripPlan.dto.SuggestionDTO;
import com.teamProject.tripPlan.entity.Comment;
import com.teamProject.tripPlan.entity.SuggestionComment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SuggestionCommentService {

    private final SuggestionCommentDAO suggestionCommentDAO;

    public void insertSuggestionComment(Long suggestionId, SuggestionCommentDTO dto) {
        suggestionCommentDAO.insertSuggestionComment(suggestionId, SuggestionCommentDTO.fromDTO(dto));
    }

    public Long deleteSuggestionComment(Long commentId) {
        return suggestionCommentDAO.deleteSuggestionComment(commentId);
    }

    public Map<String, Object> findBySuggestionCommentId(Long commentId) {
        SuggestionComment comment = suggestionCommentDAO.findByCommentId(commentId);
        Map<String, Object> map = new HashMap<>();
        map.put("comment", comment);
        map.put("suggestionId", comment.getSuggestion().getSuggestionId());
        return map;
    }

    public void updateComment(SuggestionCommentDTO dto) {
        suggestionCommentDAO.updateComment(SuggestionCommentDTO.fromDTO(dto));
    }

}
