package com.teamProject.tripPlan.controller;

import com.teamProject.tripPlan.dto.UsersDTO;
import com.teamProject.tripPlan.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String login() {
        return "member/login";
    }

    @GetMapping("/join")
    public String join() {
        return "member/join";
    }

    @PostMapping("/joinProc")
    public String joinProcess(UsersDTO usersDTO) {
        LoginService.joinProcess(usersDTO);
        return "redirect:member/login";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        if (!ObjectUtils.isEmpty(authentication)) {
            new SecurityContextLogoutHandler()
                    .logout(request, response, authentication);
        }

        return "redirect:/member/login";
    }
}
