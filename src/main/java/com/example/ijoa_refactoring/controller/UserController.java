package com.example.ijoa_refactoring.controller;


import com.example.ijoa_refactoring.data.dto.AccountRegisterDto;
import com.example.ijoa_refactoring.data.dto.TokenDto;
import com.example.ijoa_refactoring.data.dto.LoginDto;
import com.example.ijoa_refactoring.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.*;
import com.example.ijoa_refactoring.data.dto.JoinDto;
import com.example.ijoa_refactoring.service.UserService;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin
public class UserController {
    private final UserService userService;



    public UserController(UserService userService) {
        this.userService = userService;

    }

    @PostMapping("/api/user/join")
    public ResponseEntity<String> join(@RequestBody JoinDto joinDto){
        return ResponseEntity.ok(userService.registerUser(joinDto));
    }

    @PostMapping("/api/registerAccount")
    public ResponseEntity<String> registerAccount(@RequestBody AccountRegisterDto accountRegisterDto) {
        userService.registerAccount(accountRegisterDto);
        return ResponseEntity.ok("계좌가 등록되었습니다.");
    }
    @GetMapping("/admin")
    public String adminTest(){
        return "관리자";

    }





}
