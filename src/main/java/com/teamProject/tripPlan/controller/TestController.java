package com.teamProject.tripPlan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/")
    public String Test() {
        return "main";
    }
    @GetMapping("/community")
    public String communityTest() {
        return "community";
    }
}
