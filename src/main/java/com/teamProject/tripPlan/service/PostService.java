package com.teamProject.tripPlan.service;

import com.teamProject.tripPlan.dao.PostDAO;
import com.teamProject.tripPlan.dto.PostDTO;
import com.teamProject.tripPlan.dto.UsersDTO;
import com.teamProject.tripPlan.entity.Post;
import com.teamProject.tripPlan.entity.Travel;
import com.teamProject.tripPlan.entity.Users;
import com.teamProject.tripPlan.repository.PostRepository;
import com.teamProject.tripPlan.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    PostDAO dao;

    @Autowired
    UserRepository userRepository;

    public List<PostDTO> findAllPost() {
        // 키워드를 포함하여 모든 게시물을 가져오는 메소드 호출
        return dao.findAllPost().stream().map(PostDTO::fromEntity).toList();
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

    public List<PostDTO> findPostsByKeywordId(Long keywordId) {
        return dao.findPostsByKeywordId(keywordId).stream()
                .map(PostDTO::fromEntity)
                .toList();
    }

    public void insertPost(Long userNo, PostDTO dto) {
        // Users 객체를 가져와서 PostDTO에 설정
        Users user = userRepository.findById(userNo)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // PostDTO에 사용자 설정
        dto.setUsers(user);

        // PostDTO를 Post로 변환 후 DAO에 저장
        Post post = PostDTO.fromDTO(dto);

        // Travel 객체 설정
        Travel travel = dto.getTravel();
        if (travel != null) {
            travel.setUsers(user); // 여행 정보에 사용자 설정
            post.setTravel(travel);
        }

        // 키워드가 null인 경우 초기화
        if (post.getKeyword() == null) {
            post.setKeyword(dto.getKeyword());
        }

        postRepository.save(post); // JPA를 통해 저장
    }

}