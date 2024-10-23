package com.teamProject.tripPlan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/myPage")
public class MyPageController {
    @GetMapping("")
    public String myPageMain() {
        return "/myPage/myPageMain";
    }

    @GetMapping("/list")
    public String myTravelList() {
        return "/myPage/myTravelList";
    }

    @PostMapping("/list")
    public String showTravelList(@RequestParam(required = false) String keyword,
                                 @RequestParam(required = false) String area,
                                 Model model) {
        model.addAttribute("keyword", keyword);
        model.addAttribute("area", area);
        return "/myPage/myTravelList";
    }

    @GetMapping("/info")
    public String myInfo() {
        return "/myPage/myInfo";
    }
}
