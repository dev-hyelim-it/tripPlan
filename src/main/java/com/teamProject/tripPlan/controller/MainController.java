package com.teamProject.tripPlan.controller;

import com.teamProject.tripPlan.dto.MainDTO;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/main")
    public String Main() {
        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("메인입니당+========================="+id);
        return "main";

    }

    @PostMapping("/main")
    public String submit(@ModelAttribute MainDTO mainDTO, Model model) {

        model.addAttribute("searchResult", mainDTO);
        // 결과 페이지로 리다이렉트 또는 이동
        return "main"; // result.html 페이지로 이동
    }
}