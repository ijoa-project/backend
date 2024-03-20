package com.example.ijoa_refactoring.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int locationId;

    private String si;


    @ElementCollection
    private List<String> gu;

    @OneToOne
    private Application application;


}
