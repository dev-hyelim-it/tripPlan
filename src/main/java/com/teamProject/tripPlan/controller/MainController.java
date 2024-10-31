package com.teamProject.tripPlan.controller;

import com.teamProject.tripPlan.dto.DateRequestDTO;
import com.teamProject.tripPlan.dto.KakaoApiResponseDTO;
import com.teamProject.tripPlan.dto.MyListDTO;
import com.teamProject.tripPlan.entity.Travel;
import com.teamProject.tripPlan.entity.TravelDates;
import com.teamProject.tripPlan.repository.TravelRepository;
import com.teamProject.tripPlan.dto.MainDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import com.teamProject.tripPlan.service.*;
import com.teamProject.tripPlan.service.MyListService;
import com.teamProject.tripPlan.entity.MbtiTestResult;
import com.teamProject.tripPlan.entity.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;

import java.security.Principal;

import java.util.List;


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
    private final MyListService myListService;
    private final TravelRepository travelRepository;

    @Autowired
    public MainController(KakaoKeywordSearchService keywordSearchService, MyListService myListService, TravelRepository travelRepository) {
        this.keywordSearchService = keywordSearchService;
        this.myListService = myListService;
        this.travelRepository = travelRepository;
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
        // 상위 5개 장소 리스트를 모델에 추가
        List<String> top5Places = myListService.getTop5PlaceNames();
        model.addAttribute("top5Places", top5Places);

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
    public ResponseEntity<?> saveMyList(@RequestBody List<MyListDTO> myListDTOs, Model model, Travel travel, @RequestBody DateRequestDTO dateRequestDTO) {
        // 트래블 테이블 저장
        Travel travel1 = new Travel();
        travel1.setStartDate(LocalDateTime.parse(dateRequestDTO.getTravelDates().getStartDate()));
        travel1.setEndDate(LocalDateTime.parse(dateRequestDTO.getTravelDates().getEndDate()));

        Travel saveDates = myListService.insertDate(travel1);
        System.out.println(saveDates);
        // model.addAttribute("date", new Travel());
        // Travel travelDates = myListService.insertDate(travel);
//        System.out.println(travelDates);
//        System.out.println("트래블 아이디 : " + travelDates.getTravelId() +
//                "떠난 날 : " + travelDates.getStartDate() + "도착한 날 : " + travelDates.getEndDate());
//        Long travelId = saveDates.getTravelId();  // 생성된 travel_id 가져오기
        // 각 MyListyDTO에 travel_id 설정
//        for (MyListDTO myListDTO : myListDTOs) {
//            myListDTO.setTravelId(travelId);
//        }
            // 마이리스트 테이블 저장
            myListService.saveMyList(myListDTOs);
        return ResponseEntity.ok().build();
    }

}