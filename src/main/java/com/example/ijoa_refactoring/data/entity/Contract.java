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
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contractId;
    private int careRequestId;
    private int dolbomiId;
    private int parentId;
    @ElementCollection
    private List<String> date;
    private String startTime;
    private String endTime;
    private String regularity;
    private String region;
    @ElementCollection
    private List<String> careType;
    @ElementCollection
    private List<String> day;
    private int totalCost;
    private String paymentState;


}
