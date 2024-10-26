package com.teamProject.tripPlan.controller;

import com.teamProject.tripPlan.dto.KeywordDTO;
import com.teamProject.tripPlan.dto.PostDTO;
import com.teamProject.tripPlan.dto.UsersDTO;
import com.teamProject.tripPlan.entity.Keyword;
import com.teamProject.tripPlan.entity.Users;
import com.teamProject.tripPlan.repository.KeywordRepository;
import com.teamProject.tripPlan.repository.UserRepository;
import com.teamProject.tripPlan.service.KeywordService;
import com.teamProject.tripPlan.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/main")
    public String adminMainView() {
        return "admin/adminMain";
    }

    @GetMapping("/customer")
    public String adminCustomerView(Model model) {
        model.addAttribute("usersList", userRepository.findAll());
        return "admin/adminCustomer";
    }

    @GetMapping("/keyword")
    public String adminKeywordView(Model model, KeywordDTO dto) {
        model.addAttribute("keywords", keywordService.findAllKeywords());
        model.addAttribute("dto", dto);
        return "admin/adminKeyword";
    }

    @GetMapping("/insert/keyword")
    public String adminInsertKeyword(@ModelAttribute("dto") KeywordDTO dto, Model model) {
        model.addAttribute("dto", new KeywordDTO());

        return "/admin/adminInsertKeyword";
    }

    @PostMapping("/keywordInsert")
    public String createPost(KeywordDTO dto) {
        keywordService.insertKeyword(dto);
        return "redirect:/admin/keyword";
    }

    @GetMapping("{keywordId}/delete")
    public String deleteKeyword(@PathVariable("keywordId") Long keywordId,
                                RedirectAttributes redirectAttributes,
                                KeywordDTO dto) {
        keywordService.deleteKeyword(keywordId);
        redirectAttributes.addFlashAttribute("msg", "정상적으로 삭제되었습니다.");

        return "redirect:/admin/keyword";
    }

    @GetMapping("/community")
    public String adminCommunityView(Model model) {

        model.addAttribute("posts", postService.findAllPost());
        return "admin/adminCommunity";
    }
}
