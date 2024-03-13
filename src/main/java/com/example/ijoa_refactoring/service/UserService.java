package com.example.ijoa_refactoring.service;

import com.example.ijoa_refactoring.data.dto.AccountRegisterDto;
import com.example.ijoa_refactoring.data.dto.JoinDto;
import com.example.ijoa_refactoring.data.dto.LoginDto;
import com.example.ijoa_refactoring.data.dto.TokenDto;
import com.example.ijoa_refactoring.data.entity.Account;
import com.example.ijoa_refactoring.data.entity.Dolbomi;
import com.example.ijoa_refactoring.data.entity.Parent;
import com.example.ijoa_refactoring.data.repository.AccountRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import com.example.ijoa_refactoring.data.entity.Dolbomi;
import com.example.ijoa_refactoring.data.entity.Parent;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.ijoa_refactoring.data.repository.DolbomiRepository;
import com.example.ijoa_refactoring.data.repository.ParentRepository;


@Service
public class UserService {
    private DolbomiRepository dolbomiRepository;
    private ParentRepository parentRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private AccountRepository accountRepository;



    public UserService(DolbomiRepository dolbomiRepository, ParentRepository parentRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
                       AccountRepository accountRepository) {
        this.dolbomiRepository = dolbomiRepository;
        this.parentRepository = parentRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.accountRepository = accountRepository;
    }



    public String registerUser(JoinDto joinDto){


        if(dolbomiRepository.existsByUserId(joinDto.getId())){
            return "아이디가 중복입니다.";
        }else if(parentRepository.existsByUserId(joinDto.getId())){
            return "아이디가 중복입니다.";
        }

        if(joinDto.getPosition().equals("dolbomi")){
            Dolbomi dolbomi = new Dolbomi();
            dolbomi.setName(joinDto.getName());
            dolbomi.setUserId(joinDto.getId());
            dolbomi.setRole("Dolbomi");
            dolbomi.setPw(bCryptPasswordEncoder.encode(joinDto.getPw()));
            dolbomi.setGender(joinDto.getGender());
            dolbomi.setBirth(joinDto.getBirthDate());
            dolbomi.setPhone(joinDto.getPhone());
            dolbomi.setEmail(joinDto.getEmail());
            dolbomiRepository.save(dolbomi);

        } else if (joinDto.getPosition().equals("parent")) {
            Parent parent = new Parent();
            parent.setName(joinDto.getName());
            parent.setRole("Parent");
            parent.setUserId(joinDto.getId());
            parent.setPw(bCryptPasswordEncoder.encode(joinDto.getPw()));
            parent.setGender(joinDto.getGender());
            parent.setBirth(joinDto.getBirthDate());
            parent.setPhone(joinDto.getPhone());
            parent.setEmail(joinDto.getEmail());
            parentRepository.save(parent);


        }
        return "회원가입 성공";
    }

    public void registerAccount(AccountRegisterDto accountRegisterDto){
        Account account = new Account();
        account.setDepositor(accountRegisterDto.getDepositor());
        account.setBank(accountRegisterDto.getBank());
        account.setAccount(accountRegisterDto.getAccount());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 사용자 정보 추출
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) principal;
                String username = userDetails.getUsername(); // 사용자 아이디 가져오기
                // 사용자 아이디를 계좌 정보에 설정
                account.setUserId(username);
            }
        }
        accountRepository.save(account);
    }



}
