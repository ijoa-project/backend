package com.example.ijoa_refactoring.service;

import com.example.ijoa_refactoring.data.dto.JoinDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void registerUser(JoinDto joinDto);
}
