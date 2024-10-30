package com.teamProject.tripPlan.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class Interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String loginId = (String) session.getAttribute("loginId");
        if (ObjectUtils.isEmpty(loginId)) {
            response.sendRedirect("/user/login");
            return false;
        }

        if ("admin".equals(loginId)) {
            return true;
        }

        // "role"이 "admin"이 아니면 특정 페이지 접근만 허용
        String requestURI = request.getRequestURI();
        if (request.getRequestURI().matches("/myPage(/.*)?")) {
            return true;
        } else {
            response.sendRedirect("/main");
            return false;
        }
    }
}