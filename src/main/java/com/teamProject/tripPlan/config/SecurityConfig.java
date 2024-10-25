package com.teamProject.tripPlan.config;

import com.teamProject.tripPlan.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig{
    @Autowired
    private LoginService service;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // 인가(접근권한) 설정
        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/", "/login", "/loginProc").permitAll()
                        .requestMatchers("/join", "/joinProc").permitAll()
                );

        // 로그인 설정
        http
                .formLogin((auth)-> auth
                                .loginPage("/login") //사용자 정의 로그인 페이지
                                .loginProcessingUrl("/loginProc") //로그인 처리 url
                                .defaultSuccessUrl("/") //로그인 성공 후 기본 url
                                .permitAll() //로그인 실패 시 url
                );

        // 로그아웃 설정
        http
                .logout((auth) -> auth
                        .logoutUrl("/logout") //로그아웃 처리 url
                        .logoutSuccessUrl("/login") //로그아웃 성공 후 리다이렉트할 url
                        .permitAll()
                );

        return http.build();
    }
}
