package com.example.ijoa_refactoring.data.dto;

import com.example.ijoa_refactoring.data.entity.CareRequest;
import com.example.ijoa_refactoring.data.entity.Dolbomi;
import com.example.ijoa_refactoring.data.entity.Parent;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ContractRegisterDto {
    private CareRequest careRequest;
    private Dolbomi dolbomi;
    private Parent parent;
    private String startDate;
    private String endDate;
    private String startTime;
    private String endTime;
    private String regularity;
    private String region;
    private List<String> careType;
    private int totalCost;

}
