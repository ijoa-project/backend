package com.example.ijoa_refactoring.jwt;

import com.example.ijoa_refactoring.auth.PrincipalDetails;
import com.example.ijoa_refactoring.data.entity.Dolbomi;
import com.example.ijoa_refactoring.data.entity.Parent;
import com.example.ijoa_refactoring.data.repository.DolbomiRepository;
import com.example.ijoa_refactoring.data.repository.ParentRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JWTFilter extends OncePerRequestFilter {


    private final JWTUtil jwtUtil;

    private DolbomiRepository dolbomiRepository;

    private ParentRepository parentRepository;



    public JWTFilter(JWTUtil jwtUtil, DolbomiRepository dolbomiRepository, ParentRepository parentRepository){
        this.jwtUtil = jwtUtil;
        this.dolbomiRepository = dolbomiRepository;
        this.parentRepository = parentRepository;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //request에서 Authorization 헤더를 찾음
        String authorization= request.getHeader("Authorization");

        //Authorization 헤더 검증
        if (authorization == null || !authorization.startsWith("Bearer ")) {

            System.out.println("token null");
            filterChain.doFilter(request, response);

            //조건이 해당되면 메소드 종료 (필수)
            return;
        }

        System.out.println("authorization now");
        //Bearer 부분 제거 후 순수 토큰만 획득
        String token = authorization.split(" ")[1];

        //토큰 소멸 시간 검증
        if (jwtUtil.isExpired(token)) {

            System.out.println("token expired");
            filterChain.doFilter(request, response);

            //조건이 해당되면 메소드 종료 (필수)
            return;
        }

        String username = jwtUtil.getUsername(token);
        String role = jwtUtil.getRole(token);

        if(dolbomiRepository.existsByUserId(username)){
            Dolbomi dolbomi = new Dolbomi();
            dolbomi.setUserId(username);
            dolbomi.setPw("temppassword");
            dolbomi.setRole(role);

            PrincipalDetails principalDetails = new PrincipalDetails(dolbomi);

            Authentication authToken = new UsernamePasswordAuthenticationToken(principalDetails,null,principalDetails.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authToken);

            filterChain.doFilter(request,response);
        }
        else if(parentRepository.existsByUserId(username)){
            Parent parent = new Parent();
            parent.setUserId(username);
            parent.setRole(role);
            parent.setPw("temppassword");

            PrincipalDetails principalDetails = new PrincipalDetails(parent);

            Authentication authToken = new UsernamePasswordAuthenticationToken(principalDetails,null,principalDetails.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authToken);

            filterChain.doFilter(request,response);
        }





    }


}
