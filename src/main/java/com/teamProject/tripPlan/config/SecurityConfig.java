package com.teamProject.tripPlan.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.OAuth2ClientDsl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    private final CustomAuthenticationSuccessHandler handler;

    public SecurityConfig(CustomAuthenticationSuccessHandler handler) {
        this.handler = handler;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // 인가(접근권한) 설정
        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/login", "/loginProc", "/main").permitAll() // "/user/**"로 들어오는 요청은 인증만 필요
                        .requestMatchers("/join", "/joinProc").permitAll() // 마찬가지
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/myPage/**", "/community").hasAnyRole("ADMIN", "USER")
                        .anyRequest().authenticated()
                );

        // 로그인 설정
        http
                .formLogin((auth) -> auth
                                .loginPage("/login") //사용자 정의 로그인 페이지
                                .loginProcessingUrl("/loginProc") //로그인 처리 url
                                .usernameParameter("userId")
                                .passwordParameter("userPassword")
                                .successHandler(handler)
//                                .defaultSuccessUrl("/main") //로그인 성공 후 기본 url
                                .permitAll()
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
