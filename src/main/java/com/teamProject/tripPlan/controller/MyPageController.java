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

    @GetMapping("{id}")
    public String myPageMain(Model model,
                             @PathVariable("id")Long id) {
        UsersDTO user = myPageService.findLoginUser(id);
        model.addAttribute("dto", user);
        List<Travel> travels = myPageService.findUserList(id);
        model.addAttribute("list", travels);
        return "/myPage/myPageMain";
    }

    @GetMapping("/list/{id}")
    public String myTravelList(Model model,
                               @PathVariable("id")Long id) {
        List<Travel> travels = myPageService.findUserList(id);
        model.addAttribute("list", travels);
        return "/myPage/myTravelList";
    }

    @GetMapping("/info/{id}")
    public String myInfo(Model model,
                         @PathVariable("id")Long id) {
        UsersDTO dto = myPageService.findLoginUser(id);
        model.addAttribute("dto", dto);
        return "/myPage/myInfo";
    }

    @GetMapping("/update/{id}")
    public String myInfoUpdate(Model model,
                               @PathVariable("id")Long id) {
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

    @GetMapping("/community/{id}")
    public String myCommunity(Model model,
                              @PathVariable("id")Long id) {
        UsersDTO dto = myPageService.findLoginUser(id);
        model.addAttribute("dto", dto);
        return "myPage/myCommunity";
    }

    @GetMapping("/delete/{id}")
    public String infoDelete(@PathVariable("id")Long id){
        myPageService.deleteInfo(id);
        return "redirect:/";
    }
}
