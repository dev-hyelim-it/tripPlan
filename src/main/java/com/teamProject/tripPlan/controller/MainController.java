package com.teamProject.tripPlan.controller;

import com.teamProject.tripPlan.dto.KakaoApiResponseDTO;
import com.teamProject.tripPlan.dto.MainDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import com.teamProject.tripPlan.entity.MbtiTestResult;
import com.teamProject.tripPlan.entity.Users;
import com.teamProject.tripPlan.service.KakaoKeywordSearchService;
import com.teamProject.tripPlan.service.MbtiTestResultService;
import com.teamProject.tripPlan.service.QueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@Slf4j
@Controller
public class MainController {

    @Autowired
    QueryService queryService;

    @Autowired
    MbtiTestResultService mbtiTestResultService;

    private final KakaoKeywordSearchService keywordSearchService;

    @Autowired
    public MainController(KakaoKeywordSearchService keywordSearchService) {
        this.keywordSearchService = keywordSearchService;
    }

    @GetMapping({"/main"})
    public String Main(Model model, HttpSession session, Principal principal) {
        String userId = principal.getName();
        Users users = queryService.findOneUser(userId); //현재 로그인한 아이디로 변경
        model.addAttribute("userNickname", users.getUserNickname());
        if (!ObjectUtils.isEmpty(users.getResultType())) {
            MbtiTestResult mbtiTestResult = mbtiTestResultService.findByResultType(users.getResultType());
            log.info(mbtiTestResult.getResultTitle());
            model.addAttribute("userType", mbtiTestResult);
        }
        return "main";

    }

    @PostMapping("/main")
    public String submit(@ModelAttribute MainDTO mainDTO, Model model) {
        model.addAttribute("searchResult", mainDTO);
        // 결과 페이지로 리다이렉트 또는 이동
        return "main"; // result.html 페이지로 이동
    }

    @PostMapping("/search")
    @ResponseBody
    public KakaoApiResponseDTO search(@RequestParam("keyword") String keyword) {
        System.out.println(keyword);
        return keywordSearchService.searchPlacesByKeyword(keyword);
    }

}