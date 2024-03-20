package com.example.ijoa_refactoring.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class DolbomiLicenseRequestDto {
    private MultipartFile license;
}
