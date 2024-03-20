package com.example.ijoa_refactoring.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int applicationId;

    @ElementCollection
    private List<String> day;

    @ElementCollection
    private List<String> time;

    @ElementCollection
    private List<String> hopeAge;

    @ElementCollection
    private List<String> hopeGender;

    @ElementCollection
    private List<String> regularity;

    @ElementCollection
    private List<String> careType;

    private String title;

    private String content;

    @OneToOne
    private Dolbomi dolbomi;









}
