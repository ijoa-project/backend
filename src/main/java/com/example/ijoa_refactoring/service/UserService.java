package com.example.ijoa_refactoring.service;

import com.example.ijoa_refactoring.data.dto.JoinDto;
import com.example.ijoa_refactoring.data.dto.LoginDto;
import com.example.ijoa_refactoring.data.dto.TokenDto;
import com.example.ijoa_refactoring.data.entity.Dolbomi;
import com.example.ijoa_refactoring.data.entity.Parent;
import com.example.ijoa_refactoring.data.entity.UserRole;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.ijoa_refactoring.data.repository.DolbomiRepository;
import com.example.ijoa_refactoring.data.repository.ParentRepository;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {
    private DolbomiRepository dolbomiRepository;
    private ParentRepository parentRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;



    public UserService(DolbomiRepository dolbomiRepository, ParentRepository parentRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.dolbomiRepository = dolbomiRepository;
        this.parentRepository = parentRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }



    public String registerUser(JoinDto joinDto){


        if(dolbomiRepository.existsById(joinDto.getId())){
            return "아이디가 중복입니다.";
        }else if(parentRepository.existsById(joinDto.getId())){
            return "아이디가 중복입니다.";
        }

        if(joinDto.getPosition().equals("dolbomi")){
            Dolbomi dolbomi = new Dolbomi();
            dolbomi.setName(joinDto.getName());
            dolbomi.setId(joinDto.getId());
            dolbomi.setRole(UserRole.Dolbomi);
            dolbomi.setPw(bCryptPasswordEncoder.encode(joinDto.getPw()));
            dolbomi.setGender(joinDto.getGender());
            dolbomi.setBirth(joinDto.getBirthDate());
            dolbomi.setPhone(joinDto.getPhone());
            dolbomi.setEmail(joinDto.getEmail());
            dolbomiRepository.save(dolbomi);

        } else if (joinDto.getPosition().equals("parent")) {
            Parent parent = new Parent();
            parent.setName(joinDto.getName());
            parent.setRole(UserRole.Parent);
            parent.setId(joinDto.getId());
            parent.setPw(bCryptPasswordEncoder.encode(joinDto.getPw()));
            parent.setGender(joinDto.getGender());
            parent.setBirth(joinDto.getBirthDate());
            parent.setPhone(joinDto.getPhone());
            parent.setEmail(joinDto.getEmail());
            parentRepository.save(parent);


        }
        return "회원가입 성공";
    }




}
