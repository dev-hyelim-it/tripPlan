//package com.teamProject.tripPlan.controller;
//
//import com.teamProject.tripPlan.service.LoginService;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.util.ObjectUtils;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class LoginController {
//    @Autowired
//    private LoginService loginService;
//
//    @GetMapping("/login")
//    public String login() {
//        return "/member/login";
//    }
//
//    @GetMapping("/join")
//    public String join() {
//        return "/member/join";
//    }
//
//    @GetMapping("/forgot-username")
//    public String forgotUsernameForm() {
//        return "forgot-username";
//    }
//
//    @PostMapping("/forgot-username")
//    public String forgotUsername(@RequestParam("email")String email, Model model) {
//        String username = loginService.findUsernameByEmail(email);
//
//        return "forgot-username";
//    }
//}
