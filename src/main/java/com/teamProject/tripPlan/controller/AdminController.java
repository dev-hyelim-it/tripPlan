package com.teamProject.tripPlan.controller;

import com.teamProject.tripPlan.entity.Keyword;
import com.teamProject.tripPlan.service.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.PublicKey;

@Controller
public class AdminController {

    @Autowired
    KeywordService keywordService;

    @GetMapping("/adminMain")
    public String adminMainView() {
        return "admin/adminMain";
    }

    @GetMapping("/admin/customer")
    public String adminCustomerView() {
        return "admin/adminCustomer";
    }

    @GetMapping("/admin/keyword")
    public String adminKeywordView(Model model, Keyword keyword) {
        model.addAttribute("dto", keywordService.findAllKeywords());
        return "admin/adminKeyword";
    }

    @GetMapping("/admin/community")
    public String adminCommunityView() {
        return "admin/adminCommunity";
    }
}
