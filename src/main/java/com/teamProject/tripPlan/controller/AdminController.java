package com.teamProject.tripPlan.controller;

import com.teamProject.tripPlan.dto.KeywordDTO;
import com.teamProject.tripPlan.repository.UserRepository;
import com.teamProject.tripPlan.service.KeywordService;
import com.teamProject.tripPlan.service.PostService;
import com.teamProject.tripPlan.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    KeywordService keywordService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostService postService;

    @Autowired
    UsersService usersService;

    @GetMapping("/main")
    public String adminMainView() {
        return "admin/adminMain";
    }

    @GetMapping("/customer")
    public String adminCustomerView(Model model) {
        model.addAttribute("usersList", userRepository.findAll());
        return "admin/adminCustomer";
    }

    @DeleteMapping("/{userNo}/delete/customer")
    public String deleteUser(@PathVariable("userNo") Long userNo) {
        usersService.deleteUser(userNo);
        return "redirect:/admin/customer";
    }

//    @GetMapping("/keyword")
//    public String adminKeywordView(Model model, KeywordDTO dto) {
//        model.addAttribute("keywords", keywordService.findAllKeywords());
//        model.addAttribute("dto", dto);
//        return "admin/adminKeyword";
//    }

    @GetMapping("/insert/keyword")
    public String adminInsertKeywordView(@ModelAttribute("dto") KeywordDTO dto, Model model) {
        model.addAttribute("dto", new KeywordDTO());

        return "/admin/adminInsertKeyword";
    }

//    @PostMapping("/keywordInsert")
//    public String createKeyword(KeywordDTO dto) {
//        keywordService.insertKeyword(dto);
//        return "redirect:/admin/keyword";
//    }

//    @DeleteMapping("/{keywordId}/delete/keyword")
//    public String deleteKeyword(@PathVariable("keywordId") Long keywordId) {
//        keywordService.deleteKeyword(keywordId);
//        return "redirect:/admin/keyword";
//    }

    @DeleteMapping("/{postId}/delete/post")
    public String deletePost(@PathVariable("postId") Long postId) {
        postService.deletePost(postId);
        return "redirect:/admin/community";
    }

    @GetMapping("/community")
    public String adminCommunityView(Model model) {

        model.addAttribute("posts", postService.findAllPost());
        return "admin/adminCommunity";
    }

//    @GetMapping("/{keywordId}/update/keyword")
//    public String adminKeywordUpdateView(@PathVariable("keywordId") Long keywordId, Model model) {
//        model.addAttribute("dto", keywordService.findOneKeyword(keywordId));
//        return "admin/adminUpdateKeyword";
//    }

//    @PostMapping("/{keywordId}/updateKeyword")
//    public String updateKeyword( KeywordDTO dto) {
//        keywordService.updateKeyword(dto);
//        return "redirect:/admin/keyword";
//    }
}
