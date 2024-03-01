package com.example.ijoa_refactoring.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Getter
@NoArgsConstructor
@Setter
public class LoginDto {
    private String username;
    private String password;

    public UsernamePasswordAuthenticationToken toAuthentication(String username, String password) {
        return new UsernamePasswordAuthenticationToken(username, password);
    }
}
