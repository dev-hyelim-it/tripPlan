package com.teamProject.tripPlan.controller;

import com.teamProject.tripPlan.dto.PostDTO;
import com.teamProject.tripPlan.dto.UsersDTO;
import com.teamProject.tripPlan.entity.Accommodation;
import com.teamProject.tripPlan.entity.Travel;
import com.teamProject.tripPlan.entity.TravelAccommodation;
import com.teamProject.tripPlan.repository.PostRepository;
import com.teamProject.tripPlan.repository.UserRepository;
import com.teamProject.tripPlan.service.MyPageService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/myPage")
public class MyPageController {
    @Autowired
    MyPageService myPageService;

    // 로그인된 유저의 마이페이지 출력
    @GetMapping("{userId}")
    public String myPageMain(Model model,
                             @PathVariable("userId")String userId) {
        System.out.println(userId);
        Long id = myPageService.findUserId(userId);
        UsersDTO user = myPageService.findLoginUser(id);
        model.addAttribute("dto", user);
        List<Travel> travels = myPageService.findUserList(id);
        model.addAttribute("list", travels);
        return "/myPage/myPageMain";
    }

    // 유저의 여행 리스트
    @GetMapping("/list/{userId}")
    public String myTravelList(Model model,
                               @PathVariable("userId") String userId) {
        Long id = myPageService.findUserId(userId);
        List<Travel> travels = myPageService.findUserList(id);
        model.addAttribute("list", travels);
        return "/myPage/myTravelList";
    }

    // 유저의 상세 정보
    @GetMapping("/info/{userId}")
    public String myInfo(Model model,
                         @PathVariable("userId")String userId) {
        Long id = myPageService.findUserId(userId);
        UsersDTO dto = myPageService.findLoginUser(id);
        model.addAttribute("dto", dto);
        return "/myPage/myInfo";
    }

    // 정보수정 폼 출력
    @GetMapping("/update/{userId}")
    public String myInfoUpdate(Model model,
                               @PathVariable("userId")String userId) {
        Long id = myPageService.findUserId(userId);
        UsersDTO dto = myPageService.findLoginUser(id);
        model.addAttribute("dto", dto);
        return "/myPage/myInfoUpdate";
    }

    // 정보수정
    @PostMapping("/update")
    public String infoUpdate(UsersDTO dto,
                             HttpSession session) {
        UsersDTO usersDTO = myPageService.updateInfo(dto);
        String redirectUrl = "redirect:/myPage/info/" + dto.getUserId();
        session.setAttribute("loginId", usersDTO.getUserId());
        return redirectUrl;
    }

    // 유저가 작성한 커뮤니티 게시글
    @GetMapping("/community/{userId}")
    public String myCommunity(Model model,
                              @PathVariable("userId")String userId) {
        Long id = myPageService.findUserId(userId);
        UsersDTO dto = myPageService.findLoginUser(id);
        model.addAttribute("dto", dto);
        return "myPage/myCommunity";
    }

    // 회원탈퇴
    @GetMapping("/delete/{userId}")
    public String infoDelete(@PathVariable("userId")String userId,
                             HttpSession session) {
        Long id = myPageService.findUserId(userId);
        myPageService.deleteInfo(id);
        session.invalidate();
        return "redirect:/main";
    }
}