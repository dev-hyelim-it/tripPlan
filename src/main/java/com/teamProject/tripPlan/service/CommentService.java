package com.teamProject.tripPlan.service;

import com.teamProject.tripPlan.dao.CommentDAO;
import com.teamProject.tripPlan.dto.CommentDTO;
import com.teamProject.tripPlan.dto.PostDTO;
import com.teamProject.tripPlan.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CommentService {

    public final CommentDAO commentDAO;

    public void insertComment(Long postId, CommentDTO dto) {
        commentDAO.insertComment(postId, CommentDTO.fromDTO(dto));
    }

    public void insertSuggestionComment(Long suggestionId, CommentDTO dto) {
        commentDAO.insertSuggestionComment(suggestionId, CommentDTO.fromDTO(dto));
    }

    public Long deleteComment(Long commentId) {
        return commentDAO.deleteComment(commentId);
    }

    public Long deleteSuggestionComment(Long commentId) {
        return commentDAO.deleteSuggestionComment(commentId);
    }

    public Map<String, Object> findByCommentId(Long commentId) {
        Comment comment = commentDAO.findByCommentId(commentId);
        Map<String, Object> map = new HashMap<>();
        map.put("comment", comment);
        map.put("postId", comment.getPost().getPostId());
        return map;
    }

    public Map<String, Object> findBySuggestionCommentId(Long commentId) {
        Comment comment = commentDAO.findByCommentId(commentId);
        Map<String, Object> map = new HashMap<>();
        map.put("comment", comment);
        map.put("suggestionId", comment.getSuggestion().getSuggestionId());
        return map;
    }

    public void updateComment(CommentDTO dto) {
        commentDAO.updateComment(CommentDTO.fromDTO(dto));
    }
}
