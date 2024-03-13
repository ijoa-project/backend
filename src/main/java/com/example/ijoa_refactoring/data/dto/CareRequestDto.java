package com.example.ijoa_refactoring.data.dto;

import jakarta.persistence.ElementCollection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CareRequestDto {
    @ElementCollection
    private List<String> careType;
    private String startDate;
    private String endDate;
    private String startTime;
    private String endTime;
    private String time;
    private String regularity;
    private String childGender;
    private int childAge;
    private String region;
    private String title;
    private String content;
}
