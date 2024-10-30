package com.teamProject.tripPlan.service;

import com.teamProject.tripPlan.dao.KeywordDAO;
import com.teamProject.tripPlan.dao.PostDAO;
import com.teamProject.tripPlan.dao.SuggestionDAO;
import com.teamProject.tripPlan.dao.UsersDAO;
import com.teamProject.tripPlan.dto.PostDTO;
import com.teamProject.tripPlan.dto.SuggestionDTO;
import com.teamProject.tripPlan.dto.UsersDTO;
import com.teamProject.tripPlan.entity.Post;
import com.teamProject.tripPlan.entity.Users;
import com.teamProject.tripPlan.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    }

    public void deleteUser(Long userNo) {
        dao.deleteUser(userNo);
    }


    public void insertSuggestion(Long userNo, SuggestionDTO dto) {
        suggestionDAO.insertSuggestion(userNo, SuggestionDTO.fromDTO(dto));
    }
}
