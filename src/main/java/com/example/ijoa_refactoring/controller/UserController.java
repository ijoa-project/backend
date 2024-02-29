package com.example.ijoa_refactoring.controller;


import com.example.ijoa_refactoring.data.dto.TokenDto;
import com.example.ijoa_refactoring.data.dto.LoginDto;
import com.example.ijoa_refactoring.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.ijoa_refactoring.data.dto.JoinDto;
import com.example.ijoa_refactoring.service.UserService;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginDto loginRequestDto) {
        return ResponseEntity.ok(userService.login(loginRequestDto));
    }

//    @PostMapping("/join")
//    public ResponseEntity<String> join(@RequestBody JoinDto joinRequestDto) {
//        userService.registerUser(joinRequestDto);
//        return ResponseEntity.ok("성공적으로 회원가입이 완료되었습니다.");
//    }
}
