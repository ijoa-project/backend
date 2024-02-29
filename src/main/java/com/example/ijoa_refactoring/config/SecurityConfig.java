package com.example.ijoa_refactoring.config;


import com.example.ijoa_refactoring.jwt.JwtAccessDeniedHandler;
import com.example.ijoa_refactoring.jwt.JwtAuthenticationEntryPoint;
import com.example.ijoa_refactoring.jwt.JwtSecurityConfig;
import com.example.ijoa_refactoring.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {

    private final TokenProvider tokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 우리는 jwt 토큰을 이용해서 인증할 것이기 때문에, 세션을 사용하지 않겠다.

                .and()
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)

                .and()
                .formLogin().disable() // 우리는 jwt 토큰을 이용해서 인증할 것이기 때문에, form 태그를 만들어서 로그인 하는 방식을 사용하지 않겠다.
                .httpBasic().disable() // 우리는 jwt 토큰을 이용해서 인증할 것이기 때문에, httpBasic 방식을 사용하지 않겠다.
                .apply(new JwtSecurityConfig(tokenProvider)) // 커스텀 필터 등록

                .and()
                .authorizeRequests()
                .anyRequest().permitAll()
        ;
        return http.build();
    }
}