package com.teamProject.tripPlan.controller;

import com.teamProject.tripPlan.dto.UsersDTO;
import com.teamProject.tripPlan.entity.Place;
import com.teamProject.tripPlan.entity.Travel;
import com.teamProject.tripPlan.service.MyPageService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/myPage")
public class MyPageController {
    @Autowired
    MyPageService myPageService;

    // 사용자의 마이페이지
    @GetMapping("{userId}")
    public String myPageMain(Model model,
                             @PathVariable("userId") String userId) {
        Long id = myPageService.findUserId(userId);
        UsersDTO user = myPageService.findLoginUser(id);

        List<Travel> travels = myPageService.findUserList(id);
        if (travels.isEmpty()) {
            model.addAttribute("place", new ArrayList<>());
        } else {
            List<Place> places = myPageService.findPlace(id);
//            List<Place> places = myPageService.findPlace(travels.get(0).getTravelId());
            model.addAttribute("place", places);
        }

        Map<Long, String> firstPlaceNames = new HashMap<>();
        for (Travel travel : travels) {
            firstPlaceNames.put(travel.getTravelId(), travel.getPlaces().get(0).getAddressName());
        }
        model.addAttribute("dto", user);
        model.addAttribute("list", travels);
        model.addAttribute("firstPlaceNames", firstPlaceNames);
        return "/myPage/myPageMain";
    }

    // 유저의 여행 리스트
    @GetMapping("/list/{userId}")
    public String myTravelList(Model model, @PathVariable("userId") String userId) {
        Long id = myPageService.findUserId(userId);
        List<Travel> travels = myPageService.findUserList(id);
        UsersDTO user = myPageService.findLoginUser(id);
        model.addAttribute("dto", user);
        model.addAttribute("list", travels);
        if (travels.isEmpty()) {
            model.addAttribute("place", new ArrayList<>());
        } else {
            List<Place> places = myPageService.findPlace(id);
            model.addAttribute("place", places);
        }
        return "/myPage/myTravelList";
    }

    // 사용자의 상세 정보
    @GetMapping("/info/{userId}")
    public String myInfo(Model model, @PathVariable("userId") String userId) {
        Long id = myPageService.findUserId(userId);
        UsersDTO dto = myPageService.findLoginUser(id);
        model.addAttribute("dto", dto);
        return "/myPage/myInfo";
    }

    // 정보 수정 페이지
    @GetMapping("/update/{userId}")
    public String myInfoUpdate(Model model, @PathVariable("userId") String userId) {
        Long id = myPageService.findUserId(userId);
        UsersDTO dto = myPageService.findLoginUser(id);
        model.addAttribute("dto", dto);
        return "/myPage/myInfoUpdate";
    }

    // 정보 수정처리
    @PostMapping("/update")
    public String infoUpdate(UsersDTO dto, HttpSession session) {
        UsersDTO usersDTO = myPageService.updateInfo(dto);
        String redirectUrl = "redirect:/myPage/info/" + dto.getUserId();
        session.setAttribute("loginId", usersDTO.getUserId());
        return redirectUrl;
    }

    // 사용자가 작성한 커뮤니티 게시글
    @GetMapping("/community/{userId}")
    public String myCommunity(Model model, @PathVariable("userId") String userId) {
        Long id = myPageService.findUserId(userId);
        UsersDTO dto = myPageService.findLoginUser(id);
        model.addAttribute("dto", dto);
        return "myPage/myCommunity";
    }

    // 회원탈퇴
    @GetMapping("/delete/{userId}")
    public String infoDelete(@PathVariable("userId") String userId, HttpSession session) {
        Long id = myPageService.findUserId(userId);
        myPageService.deleteInfo(id);
        session.invalidate();
        return "redirect:/main";
    }
}