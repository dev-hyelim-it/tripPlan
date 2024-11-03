package com.teamProject.tripPlan.dao;

import com.teamProject.tripPlan.dto.PostDTO;
import com.teamProject.tripPlan.entity.Post;
import com.teamProject.tripPlan.entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Component
@Transactional
public class PostDAO {

    @Autowired
    EntityManager em;

    public void insertPost(Long userNo, Post post) {
        Users users = em.find(Users.class, userNo);
        post.setUsers(users);
        users.getPosts().add(post);
        em.persist(users);
    }

    public List<Post> findAllPost() {
        String sql = "SELECT p FROM Post p " +
                "LEFT JOIN FETCH p.keyword " +
                "ORDER BY p.postId DESC";

        return em.createQuery(sql, Post.class).getResultList();
    }

    public Post getOnePost(Long postId) {
        Post post = em.find(Post.class, postId);
        return post;
    }

    public void deleteById(Long postId) {
        String sql = "DELETE FROM Post p WHERE p.postId = :postId";
        em.createQuery(sql).setParameter("postId", postId).executeUpdate();
    }

    public void updatePost(PostDTO dto) {
        Post post = em.find(Post.class, dto.getPostId());
        post.setPostTitle(dto.getPostTitle());
        post.setPostContent(dto.getPostContent());
        post.setKeyword(dto.getKeyword());
//        System.out.println("updatePost");
    }

    public void calculateLikes(Long id) {
        Post post = getOnePost(id);
        if (post != null) {  // 게시글이 존재하는 경우에만 처리
            post.setLikes(post.getLikes() + 1);
            em.persist(post);  // 변경 사항을 저장
            System.out.println("Likes incremented for post with ID: " + id);
        } else {
            System.out.println("Post with ID " + id + " not found. Cannot increment likes.");
        }
    }

    public List<Post> findPostsByKeywordId(Long keywordId) {
        String jpql = "SELECT p FROM Post p WHERE p.keyword.keywordId = :keywordId";
        return em.createQuery(jpql, Post.class)
                .setParameter("keywordId", keywordId)
                .getResultList();
    }
}