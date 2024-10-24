package com.teamProject.tripPlan.service;

import com.teamProject.tripPlan.dao.PostDAO;
import com.teamProject.tripPlan.dto.PostDTO;
import com.teamProject.tripPlan.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final PostDAO postDAO;

    public void insertPost(Long userNo, PostDTO dto) {
        postDAO.insertPost(userNo, PostDTO.fromDTO(dto));
    }


}
