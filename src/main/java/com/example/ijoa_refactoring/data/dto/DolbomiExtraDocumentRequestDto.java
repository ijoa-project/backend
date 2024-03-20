package com.example.ijoa_refactoring.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
public class DolbomiExtraDocumentRequestDto {
    private MultipartFile extraDocument;
}
