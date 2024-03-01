package com.example.ijoa_refactoring.data.dto;

import com.example.ijoa_refactoring.data.entity.Parent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ParentInfoResponseDto {
    String id;
    String name;
    String pw;
    String birth;
    String address;
    String gender;
    String email;
    String phone;

}
