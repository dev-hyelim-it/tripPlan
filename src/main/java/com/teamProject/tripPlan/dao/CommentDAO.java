package com.teamProject.tripPlan.dao;

import com.teamProject.tripPlan.entity.Comment;
import com.teamProject.tripPlan.entity.Post;
import com.teamProject.tripPlan.entity.Suggestion;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Transactional
public class CommentDAO {

    @Autowired
    EntityManager em;

    public void insertComment(Long postId, Comment comment) {
        Post post = em.find(Post.class, postId);
        comment.setPost(post);
        comment.setCommentNickname("froggg"); // 현재 로그인되어있는 사람의 닉네임으로 변경. (session.logId의 아이디)
        post.getComments().add(comment);
        em.persist(post);
    }

    public void insertSuggestionComment(Long suggestionId, Comment comment) {
        Suggestion suggestion = em.find(Suggestion.class, suggestionId);
        comment.setSuggestion(suggestion);
        comment.setCommentNickname("admin"); // 현재 로그인되어있는 사람의 닉네임으로 변경. (session.logId의 아이디)
        suggestion.getComments().add(comment);
        em.persist(suggestion);
    }

    public Long deleteComment(Long commentId) {
        Comment comment = em.find(Comment.class, commentId);
        em.remove(comment);
        return comment.getPost().getPostId();
    }

    public Long deleteSuggestionComment(Long commentId) {
        Comment comment = em.find(Comment.class, commentId);
        em.remove(comment);
        return comment.getSuggestion().getSuggestionId();
    }

    public Comment findByCommentId(Long commentId) {
        return em.find(Comment.class, commentId);
    }


    public void updateComment(Comment comment) {
        Comment newComment = em.find(Comment.class, comment.getCommentId());
        newComment.setCommentContent(comment.getCommentContent());
//        em.persist(newComment);
    }
}
