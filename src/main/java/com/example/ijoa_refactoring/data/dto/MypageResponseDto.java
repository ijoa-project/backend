package com.example.ijoa_refactoring.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MypageResponseDto {
    private String name;
    private String userId;
    private String email;
    private String position;
}
