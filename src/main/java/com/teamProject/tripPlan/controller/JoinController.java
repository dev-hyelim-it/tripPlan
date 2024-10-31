package com.teamProject.tripPlan.controller;

import com.teamProject.tripPlan.dto.UsersDTO;
import com.teamProject.tripPlan.service.JoinService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JoinController {
    private final JoinService joinService;
    public JoinController(JoinService joinService) {
        this.joinService = joinService;
    }

    // 회원가입 페이지
    @GetMapping("/join")
    public String join(Model model) {
        model.addAttribute("dto", new UsersDTO());
        return "member/join";
    }

    // 회원가입 처리
    @PostMapping("/joinProc")
    public String joinProcess(UsersDTO usersDTO) {
        joinService.joinProcess(usersDTO);
        return "redirect:/login";
    }
}
