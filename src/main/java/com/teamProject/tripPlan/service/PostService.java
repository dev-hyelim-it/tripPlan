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
        return dao.findAllPost().stream().map(x->PostDTO.fromEntity(x)).toList();
    }

    public PostDTO getOnePost(Long postId) {
        Post post = dao.getOnePost(postId);
//        Optional<Post> post = postRepository.findById(id);
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

//    public List<PostDTO> findAllPost() {
//        return postRepository.findAll().stream().map(x->PostDTO.fromEntity(x)).toList();
//    }

//    public void insertPost(PostDTO dto) {
//        postRepository.save(PostDTO.fromDTO(dto));
//    }

//    public PostDTO getOnePost(Long id) {
//        Optional<Post> post = postRepository.findById(id);
//        if (ObjectUtils.isEmpty(post)) {
//            return null;
//        }
//        return PostDTO.fromEntity(post.get());
//    }

//    public void deletePost(Long id) {
//        postRepository.deleteById(id);
//    }
}
