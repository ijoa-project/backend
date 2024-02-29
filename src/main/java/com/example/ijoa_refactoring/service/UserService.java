package com.example.ijoa_refactoring.service;

import com.example.ijoa_refactoring.config.SecurityUtil;
import com.example.ijoa_refactoring.data.dto.DolbomiInfoResponseDto;
import com.example.ijoa_refactoring.data.dto.ParentInfoResponseDto;
import com.example.ijoa_refactoring.data.dto.TokenDto;
import com.example.ijoa_refactoring.data.dto.LoginDto;
import com.example.ijoa_refactoring.data.repository.DolbomiRepository;
import com.example.ijoa_refactoring.data.repository.ParentRepository;
import com.example.ijoa_refactoring.jwt.TokenProvider;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Data
@Slf4j
public class UserService {

    private DolbomiRepository dolbomiRepository;

    private final ParentRepository parentRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final TokenProvider tokenProvider;

    @Transactional
    public ParentInfoResponseDto getParentInfoBySecurity() {
        return new ParentInfoResponseDto(parentRepository.findById(SecurityUtil.getCurrentMember()));
    }

    @Transactional
    public DolbomiInfoResponseDto getDolbomiInfoBySecurity() {
        return new DolbomiInfoResponseDto(dolbomiRepository.findById(SecurityUtil.getCurrentMember()));
    }

    @Transactional
    public TokenDto login(LoginDto loginRequestDto) {

        UsernamePasswordAuthenticationToken authenticationToken = loginRequestDto.toAuthentication(loginRequestDto.getUsername(), loginRequestDto.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);


        return tokenProvider.generateTokenDto(authentication);
    }
}
//import com.example.ijoa_refactoring.data.dto.JoinDto;
//import org.springframework.stereotype.Service;
//
//@Service
//public interface UserService {
//    void registerUser(JoinDto joinDto);
//}
