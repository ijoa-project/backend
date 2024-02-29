package com.example.ijoa_refactoring.data.dto;

import com.example.ijoa_refactoring.data.entity.Parent;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
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


    public ParentInfoResponseDto(Parent parent) {
        this.id = parent.getId();
        this.name = parent.getName();
        this.pw = parent.getPw();
        this.birth = parent.getBirth();
        this.address = parent.getAddress();
        this.gender = parent.getGender();
        this.email = parent.getEmail();
        this.phone = parent.getPhone();
    }
}
