package com.teamProject.tripPlan.service;

import com.teamProject.tripPlan.dao.PostDAO;
import com.teamProject.tripPlan.dto.PostDTO;
import com.teamProject.tripPlan.dto.UsersDTO;
import com.teamProject.tripPlan.entity.Post;
import com.teamProject.tripPlan.entity.Users;
import com.teamProject.tripPlan.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final PostDAO postDAO;
    private final UserRepository userRepository;

    public void insertPost(Long userNo, PostDTO dto) {
        postDAO.insertPost(userNo, PostDTO.fromDTO(dto));
    }


    public UsersDTO findByMemberId(UsersDTO dto) {
        Users users = userRepository.findByUserId(dto.getUserId()).orElse(null);

        // 아이디 확인
        if (ObjectUtils.isEmpty(users)) {
            return null;
        }
        // 비밀번호 확인
        if (dto.getUserPassword().equals(users.getUserPassword())) {
            return UsersDTO.fromEntity(users);
        } else {
            users.setUserPassword(null);
            return UsersDTO.fromEntity(users);
        }
    }

}