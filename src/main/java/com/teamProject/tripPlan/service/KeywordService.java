package com.teamProject.tripPlan.service;

import com.teamProject.tripPlan.dao.KeywordDAO;
import com.teamProject.tripPlan.dto.KeywordDTO;
import com.teamProject.tripPlan.dto.UsersDTO;
import com.teamProject.tripPlan.entity.Keyword;
import com.teamProject.tripPlan.entity.Users;
import com.teamProject.tripPlan.repository.KeywordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class KeywordService {

    @Autowired
    KeywordDAO dao;

    @Autowired
    private KeywordRepository keywordRepository;

    public List<Keyword> findAllKeywords() {
        return keywordRepository.findAll(); // 모든 키워드 반환
    }

    public KeywordDTO findOneKeyword(Long keywordId) {
        Keyword keyword = dao.findOneKeyword(keywordId);
        if (ObjectUtils.isEmpty(keyword)) return null;
        return KeywordDTO.fromEntity(keyword);
    }

    public void saveKeyword(Keyword keyword) {
        keywordRepository.save(keyword); // 키워드 저장
    }

    public void insertKeyword(KeywordDTO dto) {
        dao.insertKeyword(KeywordDTO.fromDTO(dto));
    }

    public void deleteKeyword(Long keywordId) {
        dao.deleteKeyword(keywordId);
    }

    public void updateKeyword(KeywordDTO dto) {
        dao.updateKeyword(dto);
    }
}
