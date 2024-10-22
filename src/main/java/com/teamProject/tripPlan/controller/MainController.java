package com.teamProject.tripPlan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//sg1
@Controller
public class MainController {

    @GetMapping("/")
    public String Test() {
        return "main";
    }

    @GetMapping("/community")
    public String communityTest() {
        return "community";
    }

    @PostMapping("/community")
    public String showCommunity(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String area,
            @RequestParam String departureDate,
            @RequestParam String arrivalDate,
            Model model) {
        model.addAttribute("keyword", keyword);
        model.addAttribute("area", area);
        model.addAttribute("departureDate", departureDate);
        model.addAttribute("arrivalDate", arrivalDate);

        return "community";
    }
}
