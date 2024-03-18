package com.example.ijoa_refactoring.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class CareRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int careRequestId;
    private String day;
    private String startDate;
    private String endDate;
    private String startTime;
    private String endTime;
    private int childAge;
    private String childGender;
    private String regularity;
    private String region;
    @ElementCollection
    private List<String> careType;
    private String Title;
    private String content;
    private int state;
    private int cost;


}
