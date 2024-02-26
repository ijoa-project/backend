package com.example.ijoa_refactoring.data.entity;


import jakarta.persistence.*;
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
    private String id;
    @Column(nullable = false)
    private String pw;
    private String birth;

    private String email;
    private String address;
    private String gender;
    private String phone;

    private int care_auth;

}
