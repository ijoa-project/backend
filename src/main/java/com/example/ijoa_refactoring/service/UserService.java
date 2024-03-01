package com.example.ijoa_refactoring.service;

import com.example.ijoa_refactoring.data.dto.JoinDto;
import com.example.ijoa_refactoring.data.dto.LoginDto;
import com.example.ijoa_refactoring.data.dto.TokenDto;
import com.example.ijoa_refactoring.data.entity.Dolbomi;
import com.example.ijoa_refactoring.data.entity.Parent;
import com.example.ijoa_refactoring.jwt.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
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
    //private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManagerBuilder managerBuilder;
    private final TokenProvider tokenProvider;


    public UserService(DolbomiRepository dolbomiRepository,ParentRepository parentRepository, AuthenticationManagerBuilder managerBuilder, TokenProvider tokenProvider) {
        this.dolbomiRepository = dolbomiRepository;
        this.parentRepository = parentRepository;
        this.managerBuilder = managerBuilder;
        this.tokenProvider = tokenProvider;
    }



    public void registerUser(JoinDto joinDto){
        if(joinDto.equals("dolbomi")){
            Dolbomi dolbomi = new Dolbomi();
            dolbomi.setName(joinDto.getName());
            dolbomi.setId(joinDto.getId());
            dolbomi.setPw(joinDto.getPw());
            dolbomi.setGender(joinDto.getGender());
            dolbomi.setBirth(joinDto.getBirthDate());
            dolbomi.setPhone(joinDto.getPhone());
            dolbomi.setEmail(joinDto.getEmail());
            dolbomiRepository.save(dolbomi);
        } else if (joinDto.equals("parent")) {
            Parent parent = new Parent();
            parent.setName(joinDto.getName());
            parent.setId(joinDto.getId());
            parent.setPw(joinDto.getPw());
            parent.setGender(joinDto.getGender());
            parent.setBirth(joinDto.getBirthDate());
            parent.setPhone(joinDto.getPhone());
            parent.setEmail(joinDto.getEmail());
            parentRepository.save(parent);

        }
    }

    @Transactional
    public TokenDto login(LoginDto requestDto) {

        UsernamePasswordAuthenticationToken authenticationToken = requestDto.toAuthentication(requestDto.getUsername(),requestDto.getPassword());

        Authentication authentication = managerBuilder.getObject().authenticate(authenticationToken);

        return tokenProvider.generateTokenDto(authentication);
    }
}
