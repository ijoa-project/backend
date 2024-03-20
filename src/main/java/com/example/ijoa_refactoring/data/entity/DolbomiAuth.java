package com.example.ijoa_refactoring.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class DolbomiAuth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authId;

    private String license;

    private String healthCertification;

    private int approve;

    private String expiredDate;

    @OneToOne
    private Dolbomi dolbomi;


}
