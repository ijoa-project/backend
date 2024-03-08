package com.example.ijoa_refactoring.data.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Dolbomi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dolbomiId;
    @Column(nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String userId;
    @Column(nullable = false)
    private String pw;
    private String birth;

    private String email;
    private String address;
    private String gender;
    private String phone;

    private int care_auth;


    private String role; // 역할 매핑 추가

    @OneToOne
    private Contract contract;


}
