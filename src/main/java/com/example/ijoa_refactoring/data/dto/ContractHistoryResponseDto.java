package com.example.ijoa_refactoring.data.dto;

import lombok.Data;

import java.util.List;

@Data
public class ContractHistoryResponseDto {
    private int contractId;
    private String startDate;
    private String dolbomiName;
    private String region;
    private List<String> careType;
    private String statement;

}
