package com.teamProject.tripPlan.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 세션에 사용자 ID 저장
        HttpSession session = request.getSession();
        String username = authentication.getName();  // 시큐리티로 인증된 사용자 이름 가져오기
        session.setAttribute("loginId", username);    // 세션에 유저 ID 저장

//        System.out.println("세션에 저장된 아이디 확인 : " + username);

        // 로그인 성공 후 메인 페이지로 이동
        response.sendRedirect("/main");
    }
}
