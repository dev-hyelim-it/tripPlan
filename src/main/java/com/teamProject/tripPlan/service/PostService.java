package com.teamProject.tripPlan.service;

import com.teamProject.tripPlan.dao.PostDAO;
import com.teamProject.tripPlan.dto.PostDTO;
import com.teamProject.tripPlan.entity.Post;
import com.teamProject.tripPlan.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    PostDAO dao;

    public List<PostDTO> findAllPost() {
        // 키워드를 포함하여 모든 게시물을 가져오는 메소드 호출
        return dao.findAllPost().stream()
                .map(PostDTO::fromEntity)
                .toList();
    }

    public PostDTO getOnePost(Long postId) {
        Post post = dao.getOnePost(postId);
        if (ObjectUtils.isEmpty(post)) {
            return null;
        }
        return PostDTO.fromEntity(post);
    }

    public void deletePost(Long postId) {
        dao.deleteById(postId);
    }

    public void updatePost(PostDTO dto) {
        dao.updatePost(dto);
    }

    public void calculateLikes(Long id) {
        dao.calculateLikes(id);
    }

    public List<PostDTO> findPostsByKeyword(List<String> keywords) {
        return dao.findPostsByKeywords(keywords).stream()
                .map(PostDTO::fromEntity)
                .toList();
    }
}