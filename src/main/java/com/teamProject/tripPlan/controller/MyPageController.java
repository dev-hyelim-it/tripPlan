package com.teamProject.tripPlan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/info")
    public String myInfo() {
        return "/myPage/myInfo";
    }
}
