package com.teamProject.tripPlan.controller;

import com.teamProject.tripPlan.entity.Keyword;
import com.teamProject.tripPlan.repository.KeywordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {
    @Autowired
    private KeywordRepository keywordRepository;

    @GetMapping("/api/keywords")
    public List<String> getKeywords() {
        return keywordRepository.findAll().stream().map(Keyword::getKeyword).toList();
    }

}
