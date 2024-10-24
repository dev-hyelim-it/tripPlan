package com.teamProject.tripPlan.controller;

import com.teamProject.tripPlan.repository.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommunityController {

    @Autowired
    CommunityRepository communityRepository;

    @GetMapping("/")
    public String Test() {
        return "main";
    }
//    @GetMapping("/")
//    public String Test() {
//        return "main";
//    }

    @GetMapping("/community")
    public String communityTest(Model model) {
        model.addAttribute("posts", communityRepository.findAll());
        return "community";
    }

    @GetMapping("/community/new")
    public String createArticle() {
        return "newPost";
    }
}
