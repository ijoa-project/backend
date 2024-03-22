package com.example.ijoa_refactoring.data.dto;

import jakarta.persistence.ElementCollection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SearchRequestDto {
    private String si;
    @ElementCollection
    private List<String> gu;
    @ElementCollection
    private List<String> careType;
    @ElementCollection
    private List<String> regularity;
    @ElementCollection
    private List<String> day;

}
