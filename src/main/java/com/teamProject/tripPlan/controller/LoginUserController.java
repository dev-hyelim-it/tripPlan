package com.teamProject.tripPlan.controller;

import com.teamProject.tripPlan.dto.UsersDTO;
import com.teamProject.tripPlan.service.UsersService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class LoginUserController {
    @Autowired
    UsersService usersService;
    @GetMapping("/login")
    public String showLogin() {
        return "/member/login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("dto")UsersDTO dto,
                        BindingResult bindingResult, HttpSession session, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("loginError", "Invalid login details");
            return "/member/login";
        }
        UsersDTO users = usersService.findByMemberId(dto);
        // 아이디 확인
        if (ObjectUtils.isEmpty(users)) {
            model.addAttribute("loginError", "아이디가 올바른지 확인해주세요");
            return "/member/login";
        }
        // 비밀번호 확인
        if (users.getUserPassword() == null) {
            model.addAttribute("loginError", "비밀번호가 일치하지 않습니다");
            return "/member/login";
        } else {
            // 로그인 성공
            session.setAttribute("loginId", users.getUserId());
            // 세션 만료 시간
            session.setMaxInactiveInterval(60*30);
            return "redirect:/user/login";
        }
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/user/login";
    }
}