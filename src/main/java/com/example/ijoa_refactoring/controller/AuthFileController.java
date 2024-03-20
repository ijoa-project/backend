package com.example.ijoa_refactoring.controller;

import com.example.ijoa_refactoring.auth.FindUserInfo;
import com.example.ijoa_refactoring.data.dto.DolbomiExtraDocumentRequestDto;
import com.example.ijoa_refactoring.data.dto.DolbomiHealthCertificationRequestDto;
import com.example.ijoa_refactoring.data.dto.DolbomiLicenseRequestDto;
import com.example.ijoa_refactoring.service.DolbomiAuthService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@NoArgsConstructor
@RestController
public class AuthFileController {

    private DolbomiAuthService dolbomiAuthService;

    public  AuthFileController(DolbomiAuthService dolbomiAuthService){
        this.dolbomiAuthService = dolbomiAuthService;

    }


    @PostMapping("/api/auth/step1")
    public ResponseEntity<String> registerLicense(HttpServletRequest request, @RequestParam DolbomiLicenseRequestDto licenseRequestDto){
        String userId = FindUserInfo.getCurrentUserId();
        int result = dolbomiAuthService.uploadLicenseFile(userId, licenseRequestDto,request);

        if(result==1){
            return ResponseEntity.ok("신분증 업로드 완료!");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("신분증 업로드를 실패하였습니다!");

        }
    }

    @PostMapping("/api/auth/step3")
    public ResponseEntity<String> registerHealthCertification(HttpServletRequest request, @RequestBody DolbomiHealthCertificationRequestDto healthCertificationRequestDto){
        String userId = FindUserInfo.getCurrentUserId();

        int result = dolbomiAuthService.uploadHealthCertification(userId,healthCertificationRequestDto,request);

        if(result==1){
            return ResponseEntity.ok("보건증 등록 완료!");
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("보건증 등록 실패하였습니다!");
        }
    }

    @PostMapping("/api/auth/step4")
    public ResponseEntity<String> registerExtraDocument(HttpServletRequest request, @RequestBody DolbomiExtraDocumentRequestDto extraDocumentRequestDto){
        String userId = FindUserInfo.getCurrentUserId();

        int result = dolbomiAuthService.uploadExtraDocument(userId,extraDocumentRequestDto,request);
        if(result==1){
            return ResponseEntity.ok("추가 서류 등록 완료!");
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("추가 서류 등록 실패하였습니다!");
        }

    }


}
