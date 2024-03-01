package com.example.ijoa_refactoring.controller;

import com.example.ijoa_refactoring.data.dto.CareRequestDto;
import com.example.ijoa_refactoring.service.CareRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CareRequestController {
    private CareRequestService careRequestService;

    public CareRequestController(CareRequestService careRequestService){
        this.careRequestService = careRequestService;
    }

    @PostMapping("/registerCareRequest")
    public ResponseEntity<String> registerCareRequest(@RequestBody CareRequestDto careRequestDto){
        careRequestService.registerCareRequest(careRequestDto);
        return ResponseEntity.ok("돌봄요청이 정상적으로 등록되었습니다.");
    }
}
