package com.example.ijoa_refactoring.data.dto;

import lombok.Data;

import java.util.List;
@Data
public class ApplicationResponseDto {
    private List<String> day;
    private List<String> time;
    private List<String> hopeAge;
    private List<String> hopeGender;
    private List<String> Regularity;
    private String si;
    private List<String> gu;
    private List<String> careType;
    private String title;
    private String content;
}
