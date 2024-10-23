package com.teamProject.tripPlan.service;

import com.teamProject.tripPlan.entity.Keyword;
import com.teamProject.tripPlan.repository.KeywordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordService {

    @Autowired
    private KeywordRepository keywordRepository;

    public List<Keyword> findAllKeywords() {
        return keywordRepository.findAll(); // 모든 키워드 반환
    }

    public void saveKeyword(Keyword keyword) {
        keywordRepository.save(keyword); // 키워드 저장
    }
}
