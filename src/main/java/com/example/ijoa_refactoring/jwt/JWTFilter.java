package com.example.ijoa_refactoring.jwt;

import com.example.ijoa_refactoring.auth.PrincipalDetails;
import com.example.ijoa_refactoring.data.entity.Dolbomi;
import com.example.ijoa_refactoring.data.entity.Parent;
import com.example.ijoa_refactoring.data.entity.UserRole;
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



    public JWTFilter(JWTUtil jwtUtil){
        this.jwtUtil = jwtUtil;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");

        if(authorization==null || authorization.startsWith("Bearer ")){
            System.out.println("token null");
            filterChain.doFilter(request,response);

            return;
        }
        System.out.println("authorization now");
        String token = authorization.split(" ")[1];

        if(jwtUtil.isExpired(token)){
            System.out.println("token expired");
            filterChain.doFilter(request,response);

            return;
        }

        String username = jwtUtil.getUsername(token);
        String role = jwtUtil.getRole(token);

        if(dolbomiRepository.existsById(username)){
            Dolbomi dolbomi = new Dolbomi();
            dolbomi.setId(username);
            dolbomi.setPw("temppassword");
            dolbomi.setRole(UserRole.Dolbomi);

            PrincipalDetails principalDetails = new PrincipalDetails(dolbomi);

            Authentication authToken = new UsernamePasswordAuthenticationToken(principalDetails,null,principalDetails.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authToken);

            filterChain.doFilter(request,response);
        }
        else if(parentRepository.existsById(username)){
            Parent parent = new Parent();
            parent.setId(username);
            parent.setRole(UserRole.Parent);
            parent.setPw("temppassword");

            PrincipalDetails principalDetails = new PrincipalDetails(parent);

            Authentication authToken = new UsernamePasswordAuthenticationToken(principalDetails,null,principalDetails.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authToken);

            filterChain.doFilter(request,response);
        }





    }
}
