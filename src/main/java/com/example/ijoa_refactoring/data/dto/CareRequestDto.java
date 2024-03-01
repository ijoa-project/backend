package com.example.ijoa_refactoring.data.dto;

import jakarta.persistence.ElementCollection;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CareRequestDto {
    @ElementCollection
    private List<String> careType;
    private String term;
    private String startDate;
    private String endDate;
    private String startTime;
    private String endTime;
    private String time;
    private String regularity;
    private String childGender;
    private int childAge;
    private String city;
    private String gu;
    private String dong;
    private String detailAddress;
    private String title;
    private String content;
}
