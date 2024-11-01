package com.teamProject.tripPlan.service;

import com.teamProject.tripPlan.dao.CommentDAO;
import com.teamProject.tripPlan.dto.CommentDTO;
import com.teamProject.tripPlan.dto.PostDTO;
import com.teamProject.tripPlan.entity.Comment;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CommentService {

    public final CommentDAO commentDAO;

    public void insertComment(Long postId, CommentDTO dto, String nickname) {
        Comment comment = CommentDTO.fromDTO(dto); // DTO를 Entity로 변환
        comment.setCommentNickname(nickname); // 닉네임 설정
        commentDAO.insertComment(postId, comment, nickname); // 닉네임을 인자로 전달
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

    public List<CommentDTO> findAllComment(Long id) {
        return commentDAO.findAllComment(id).stream().map(x->CommentDTO.fromEntity(x)).toList();
    }
}
