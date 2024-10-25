package com.teamProject.tripPlan.service;

import com.teamProject.tripPlan.dao.MyPageDAO;
import com.teamProject.tripPlan.dto.PostDTO;
import com.teamProject.tripPlan.dto.UsersDTO;
import com.teamProject.tripPlan.entity.Post;
import com.teamProject.tripPlan.entity.Users;
import com.teamProject.tripPlan.repository.PostRepository;
import com.teamProject.tripPlan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyPageService {
    @Autowired
    MyPageDAO myPageDAO;

    @Autowired
    PostRepository postRepository;

    public UsersDTO findLoginUser(Long id) {
        Users users = myPageDAO.getOneUser(id);
        return UsersDTO.fromEntity(users);
    }

    public PostDTO findUserPosts(Long id) {
        Post post = myPageDAO.getUserPost(id);
        return PostDTO.fromEntity(post);
    }

    public void updateInfo(UsersDTO dto) {
        myPageDAO.updateInfo(dto);
    }

    public void deleteInfo(Long id) {
        myPageDAO.deleteInfo(id);
    }
}
