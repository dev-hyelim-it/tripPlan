package com.teamProject.tripPlan.controller;

import com.teamProject.tripPlan.repository.PostRepository;
import com.teamProject.tripPlan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/myPage")
public class MyPageController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @GetMapping("")
    public String myPageMain(Model model) {
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("posts", postRepository.findAll());
        return "/myPage/myPageMain";
    }

    @GetMapping("/list")
    public String myTravelList(Model model) {
        model.addAttribute("posts", postRepository.findAll());
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
    public String myInfo(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "/myPage/myInfo";
    }

    @GetMapping("/update")
    public String myInfoUpdate(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "/myPage/myInfoUpdate";
    }

    @GetMapping("/community")
    public String myCommunity(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        return "myPage/myCommunity";
    }
}
