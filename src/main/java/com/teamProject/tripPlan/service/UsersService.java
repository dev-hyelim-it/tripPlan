package com.teamProject.tripPlan.service;

import com.teamProject.tripPlan.dao.PostDAO;
import com.teamProject.tripPlan.dao.SuggestionDAO;
import com.teamProject.tripPlan.dao.UsersDAO;
import com.teamProject.tripPlan.dto.PostDTO;
import com.teamProject.tripPlan.dto.SuggestionDTO;
import com.teamProject.tripPlan.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.teamProject.tripPlan.dto.UsersDTO;
import com.teamProject.tripPlan.entity.Users;
import org.springframework.util.ObjectUtils;

@Service
@RequiredArgsConstructor
public class UsersService {

    @Autowired
    UsersDAO dao;

    @Autowired
    UserRepository userRepository;

    private final PostDAO postDAO;

    private final SuggestionDAO suggestionDAO;

    public void insertPost(Long userNo, PostDTO dto) {
        postDAO.insertPost(userNo, PostDTO.fromDTO(dto));
//        return userNo;
    }

    public void deleteUser(Long userNo) {
        dao.deleteUser(userNo);
    }

    public void insertSuggestion(Long userNo, SuggestionDTO dto) {
        suggestionDAO.insertSuggestion(userNo, SuggestionDTO.fromDTO(dto));
    }

    // 삭제 예정
//    public UsersDTO findByMemberId(UsersDTO dto) {
//        Users users = userRepository.findByUserId(dto.getUserId()).orElse(null);
//
//        // 아이디 확인
//        if (ObjectUtils.isEmpty(users)) {
//            return null;
//        }
//        // 비밀번호 확인
//        if (dto.getUserPassword().equals(users.getUserPassword())) {
//            return UsersDTO.fromEntity(users);
//        } else {
//            users.setUserPassword(null);
//            return UsersDTO.fromEntity(users);
//        }
//    }

}