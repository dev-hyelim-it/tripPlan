package com.teamProject.tripPlan.controller;

import com.teamProject.tripPlan.dto.*;
import com.teamProject.tripPlan.entity.Travel;
import com.teamProject.tripPlan.repository.TravelRepository;
import jakarta.servlet.http.HttpSession;
import com.teamProject.tripPlan.service.*;
import com.teamProject.tripPlan.service.MyListService;
import com.teamProject.tripPlan.entity.MbtiTestResult;
import com.teamProject.tripPlan.entity.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;

import java.security.Principal;

@Slf4j
@Controller
public class MainController {

    @Autowired
    QueryService queryService;

    @Autowired
    MbtiTestResultService mbtiTestResultService;

    @Autowired
    MyPageService myPageService;

    @Autowired
    MyListService myListService;

    private final KakaoKeywordSearchService keywordSearchService;
    private final TravelRepository travelRepository;

    @Autowired
    public MainController(KakaoKeywordSearchService keywordSearchService, MyListService myListService, TravelRepository travelRepository) {
        this.keywordSearchService = keywordSearchService;
        this.myListService = myListService;
        this.travelRepository = travelRepository;
    }

    @GetMapping({"/main"})
    public String Main(Model model, HttpSession session, Principal principal, Authentication authentication) {
        String userName = authentication.getName();
//        String userId = principal.getName();
        Users users = queryService.findOneUser(userName); //현재 로그인한 아이디로 변경
        model.addAttribute("userNickname", users.getUserNickname());
        if (!ObjectUtils.isEmpty(users.getResultType())) {
            MbtiTestResult mbtiTestResult = mbtiTestResultService.findByResultType(users.getResultType());
            log.info(mbtiTestResult.getResultTitle());
            model.addAttribute("userType", mbtiTestResult);
        }
        return "main"; // main.html 템플릿을 렌더링
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

    @PostMapping("/saveMyList")
    public ResponseEntity<?> saveMyList(Model model, Travel travel, @RequestBody List<PlaceDTO> placeDTO, Authentication authentication) {
        String userName = authentication.getName();
        Long id = myPageService.findUserId(userName);
        Travel travel1 = myPageService.insertTravelList(id);
        myListService.saveList(travel1.getTravelId(), placeDTO);
//        myListService.saveTest(placeDTO);
        return ResponseEntity.ok().build();
    }

}