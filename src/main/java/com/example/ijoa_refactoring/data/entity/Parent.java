package com.example.ijoa_refactoring.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int parentId;
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


    @OneToOne
    private Contract contract;

    private String role; // 역할 매핑 추가

}
