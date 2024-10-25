package com.teamProject.tripPlan.dao;

import com.teamProject.tripPlan.dto.PostDTO;
import com.teamProject.tripPlan.entity.Post;
import com.teamProject.tripPlan.entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        String sql = "SELECT p FROM Post p ORDER BY p.postId DESC";
        List<Post> posts = em.createQuery(sql).getResultList();
        return posts;
    }

    public Post getOnePost(Long postId) {
        Post post = em.find(Post.class, postId);
        return post;
    }

    public void deleteById(Long postId) {
        Post post = em.find(Post.class, postId);
        em.remove(post);
    }

    public void updatePost(PostDTO dto) {
        Post post = em.find(Post.class, dto.getPostId());
        post.setPostTitle(dto.getPostTitle());
        post.setPostContent(dto.getPostContent());
//        em.persist(post);
    }

    public void calculateLikes(Long id) {
        Post post = getOnePost(id);
        post.setLikes(post.getLikes()+1);
        em.persist(post);
    }
}
