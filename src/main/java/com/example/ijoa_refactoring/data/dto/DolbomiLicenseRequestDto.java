package com.example.ijoa_refactoring.data.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class DolbomiLicenseRequestDto {
    private MultipartFile license;
}
