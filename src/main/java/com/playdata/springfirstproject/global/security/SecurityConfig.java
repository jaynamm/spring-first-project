package com.playdata.springfirstproject.global.security;

import com.playdata.springfirstproject.domain.user.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity // Spring Security 설정 활성화
@Configuration // Spring 설정 클래스
public class SecurityConfig {
    private final CustomOauth2UserService customOauth2UserService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Cross-Site Request Forgrey 비활성화
                .csrf().disable()

                // headers() -> Http 응답헤더
                // X-frame-Option 헤더 설정 비활성화
                .headers()
                    .frameOptions().disable()

                // URL 권환 관리
                .and()
                    .authorizeHttpRequests()
                        // 권한 관리 대상 지정 -> url 로 지정
                        .requestMatchers("/", "/css/", "images/**", "/js/**", "/profile").permitAll() // 권한에 상관없이 접근
                        .requestMatchers("/api/vi/**").hasRole(Role.USER.name())
                        .anyRequest().authenticated()

                // 로그아웃 관련 설정
                .and()
                    .logout()
                        // 로그아웃 이후 이동되는 url
                        .logoutSuccessUrl("/")

                .and()
                    .oauth2Login()
                        .userInfoEndpoint()
                            .userService(customOauth2UserService)
        ;

        return http.build();
    }
}
