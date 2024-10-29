package com.teamProject.tripPlan.controller;

import com.teamProject.tripPlan.dto.PostDTO;
import com.teamProject.tripPlan.dto.UsersDTO;
import com.teamProject.tripPlan.entity.Accommodation;
import com.teamProject.tripPlan.entity.Travel;
import com.teamProject.tripPlan.entity.TravelAccommodation;
import com.teamProject.tripPlan.repository.PostRepository;
import com.teamProject.tripPlan.repository.UserRepository;
import com.teamProject.tripPlan.service.MyPageService;
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

    @GetMapping("/list/{userId}")
    public String myTravelList(Model model,
                               @PathVariable("userId") String userId) {
        Long id = myPageService.findUserId(userId);
        List<Travel> travels = myPageService.findUserList(id);
        model.addAttribute("list", travels);
        return "/myPage/myTravelList";
    }

    @GetMapping("/info/{userId}")
    public String myInfo(Model model,
                         @PathVariable("userId")String userId) {
        Long id = myPageService.findUserId(userId);
        UsersDTO dto = myPageService.findLoginUser(id);
        model.addAttribute("dto", dto);
        return "/myPage/myInfo";
    }

    @GetMapping("/update/{userId}")
    public String myInfoUpdate(Model model,
                               @PathVariable("userId")String userId) {
        Long id = myPageService.findUserId(userId);
        UsersDTO dto = myPageService.findLoginUser(id);
        model.addAttribute("dto", dto);
        return "/myPage/myInfoUpdate";
    }

    @PostMapping("/update")
    public String infoUpdate(UsersDTO dto) {
        String redirectUrl = "redirect:/myPage/info/1";
        myPageService.updateInfo(dto);
        return redirectUrl;
    }

    @GetMapping("/community/{userId}")
    public String myCommunity(Model model,
                              @PathVariable("userId")String userId) {
        Long id = myPageService.findUserId(userId);
        UsersDTO dto = myPageService.findLoginUser(id);
        model.addAttribute("dto", dto);
        return "myPage/myCommunity";
    }

    @GetMapping("/delete/{userId}")
    public String infoDelete(
            @PathVariable("userId")String userId) {
        Long id = myPageService.findUserId(userId);
        myPageService.deleteInfo(id);
        return "redirect:/";
    }
}
