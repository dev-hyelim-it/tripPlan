package com.teamProject.tripPlan.dao;

import com.teamProject.tripPlan.entity.Comment;
import com.teamProject.tripPlan.entity.Suggestion;
import com.teamProject.tripPlan.entity.SuggestionComment;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Transactional
public class SuggestionCommentDAO {

    @Autowired
    EntityManager em;

    public void insertSuggestionComment(Long suggestionId, SuggestionComment comment) {
        Suggestion suggestion = em.find(Suggestion.class, suggestionId);
        comment.setSuggestion(suggestion);
//        comment.setCommentNickname("admin"); // 현재 로그인되어있는 사람의 닉네임으로 변경. (session.logId의 아이디)
        suggestion.getComments().add(comment);
        em.persist(suggestion);
    }

    public Long deleteSuggestionComment(Long commentId) {
        SuggestionComment comment = em.find(SuggestionComment.class, commentId);
        em.remove(comment);
        return comment.getSuggestion().getSuggestionId();
    }

    public SuggestionComment findByCommentId(Long commentId) {
        return em.find(SuggestionComment.class, commentId);
    }


    public void updateComment(SuggestionComment comment) {
        SuggestionComment newComment = em.find(SuggestionComment.class, comment.getCommentId());
        newComment.setCommentContent(comment.getCommentContent());
//        em.persist(newComment);
    }

    public List<SuggestionComment> findAllComment(Long id) {
        String sql = "SELECT c FROM Comment c JOIN c.post p WHERE p.postId = :postId ORDER BY c.commentId DESC";
        List<SuggestionComment> commentLists = em.createQuery(sql, SuggestionComment.class).setParameter("postId", id).getResultList();
        return commentLists;
    }


}