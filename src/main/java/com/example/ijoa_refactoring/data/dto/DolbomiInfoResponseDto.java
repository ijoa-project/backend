package com.example.ijoa_refactoring.data.dto;

import com.example.ijoa_refactoring.data.entity.Dolbomi;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DolbomiInfoResponseDto {
    String id;
    String name;
    String pw;
    String birth;
    String address;
    String gender;
    String email;
    String phone;

    public DolbomiInfoResponseDto(Dolbomi dolbomi){
        id = dolbomi.getUserId();
        name = dolbomi.getName();
        pw = dolbomi.getPw();
        birth = dolbomi.getBirth();
        address = dolbomi.getAddress();
        email = dolbomi.getEmail();
        phone = dolbomi.getPhone();

    }

}
