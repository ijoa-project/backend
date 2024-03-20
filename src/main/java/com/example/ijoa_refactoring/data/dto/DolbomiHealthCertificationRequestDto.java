package com.example.ijoa_refactoring.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@Data
public class DolbomiHealthCertificationRequestDto{
    private String expiredDate;
    private MultipartFile healthCertification;
}
