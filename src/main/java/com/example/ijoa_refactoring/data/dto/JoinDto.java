package com.example.ijoa_refactoring.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JoinDto {
    private String position;
    private String name;
    private String userId;
    private String pw;
    private String birthDate;
    private String gender;
    private String phone;
    private String email;

}
