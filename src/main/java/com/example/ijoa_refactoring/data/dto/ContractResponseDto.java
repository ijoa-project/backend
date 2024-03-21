package com.example.ijoa_refactoring.data.dto;

import lombok.Data;

import java.util.List;

@Data
public class ContractResponseDto {
    private String dolbomiName;
    private String parentName;
    private List<String> date;
    private String startTime;
    private String endTime;
    private List<String> day;
    private String regularity;
    private String region;
    private List<String> careType;
    private int totalCost;
}
