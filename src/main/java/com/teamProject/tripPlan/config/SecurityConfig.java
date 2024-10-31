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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

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
        // CORS 및 CSRF 설정
        http.cors(); // 이 설정을 통해 커스터마이징된 CORS 설정이 Security Filter에 적용됨

        // CSRF 설정
        http.csrf().disable(); // REST API에 주로 사용하며, CSRF를 비활성화하여 403 오류를 방지

        // 접근권한 설정
        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/main").permitAll()
                        .requestMatchers("/login", "/loginProc", "/test", "/result").permitAll() // test, result 메인페이지 완료 시 삭제
                        .requestMatchers("/join", "/joinProc").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/myPage/**", "/community").hasAnyRole("ADMIN", "USER")
                        .anyRequest().authenticated()
                );

        // 로그인 설정
        http
                .formLogin((auth) -> auth
                                .loginPage("/login")
                                .loginProcessingUrl("/loginProc") //로그인 처리
                                .usernameParameter("userId")
                                .passwordParameter("userPassword")
                                .successHandler(handler) // 로그인 아이디를 세션에 저장하는 핸들러
                                .permitAll()
                );

        // 로그아웃 설정
        http
                .logout((auth) -> auth
                        .logoutUrl("/logout") //로그아웃 처리
                        .logoutSuccessUrl("/login") //로그아웃 성공 후 이동할 페이지
                        .permitAll()
                );


        return http.build();
    }

    // CORS 설정을 위한 빈 정의
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:8080")); // 허용할 출처 설정
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE")); // 허용할 HTTP 메서드 설정
        configuration.setAllowedHeaders(List.of("*")); // 허용할 헤더 설정
        configuration.setAllowCredentials(true); // 인증 정보 허용 여부

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
