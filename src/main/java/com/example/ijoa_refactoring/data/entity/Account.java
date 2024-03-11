package com.example.ijoa_refactoring.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Account {
    @Id
    private int accountId;
    private String depositor;
    private String bank;
    private String account;
    private String userId;
    private String userType;
}
