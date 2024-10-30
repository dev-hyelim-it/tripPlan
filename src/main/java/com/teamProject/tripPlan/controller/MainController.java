package com.teamProject.tripPlan.controller;

import com.teamProject.tripPlan.dto.KakaoApiResponseDTO;
import com.teamProject.tripPlan.service.KakaoKeywordSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    private final KakaoKeywordSearchService keywordSearchService;

    @Autowired
    public MainController(KakaoKeywordSearchService keywordSearchService) {
        this.keywordSearchService = keywordSearchService;
    }

    @GetMapping("/main")
    public String Main() {
        return "main";
    }

    @PostMapping("/search")
    @ResponseBody
    public KakaoApiResponseDTO search(@RequestParam("keyword") String keyword) {
        System.out.println(keyword);
        return keywordSearchService.searchPlacesByKeyword(keyword);
    }

}