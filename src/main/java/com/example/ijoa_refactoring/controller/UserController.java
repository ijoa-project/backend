package com.example.ijoa_refactoring.controller;


import com.example.ijoa_refactoring.data.dto.TokenDto;
import com.example.ijoa_refactoring.data.dto.LoginDto;
import com.example.ijoa_refactoring.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
}
