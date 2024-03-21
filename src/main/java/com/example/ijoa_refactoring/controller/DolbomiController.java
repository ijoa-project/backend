package com.example.ijoa_refactoring.controller;

import com.example.ijoa_refactoring.auth.FindUserInfo;
import com.example.ijoa_refactoring.data.dto.ApplicationRequestDto;
import com.example.ijoa_refactoring.data.dto.ApplicationResponseDto;
import com.example.ijoa_refactoring.data.dto.ContractHistoryResponseDto;
import com.example.ijoa_refactoring.data.dto.ContractResponseDto;
import com.example.ijoa_refactoring.data.entity.Application;
import com.example.ijoa_refactoring.service.ApplicationService;
import com.example.ijoa_refactoring.service.CareHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DolbomiController {

    private ApplicationService applicationService;

    private CareHistoryService careHistoryService;

    public DolbomiController(ApplicationService applicationService, CareHistoryService careHistoryService){
        this.applicationService = applicationService;
        this.careHistoryService = careHistoryService;
    }

    @PostMapping("/api/dolbomi/register")
    public ResponseEntity<String> registerApplication(@RequestBody ApplicationRequestDto applicationRequestDto){
        String userId = FindUserInfo.getCurrentUserId();

        Application application =applicationService.registerApplication(applicationRequestDto,userId);
        if(application!=null){
            return ResponseEntity.ok("지원서 등록 성공!");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("지원서 등록 실패!");
        }
    }

    @GetMapping("/api/dolbomi/mypage/application")
    public ResponseEntity<ApplicationResponseDto> getApplication(){
        String userId = FindUserInfo.getCurrentUserId();
        ApplicationResponseDto dto = applicationService.getApplication(userId);

        return ResponseEntity.ok(dto);
    }
    
    @PutMapping("/api/dolbomi/mypage/application")
    public  ResponseEntity<String> updateApplication(@RequestBody ApplicationRequestDto applicationRequestDto){
        String userId = FindUserInfo.getCurrentUserId();
        
        Application application = applicationService.updateApplication(userId,applicationRequestDto);
        
        if(application!=null){
            return ResponseEntity.ok("지원서 수정 성공!");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("지원서 수정 실패!");
        }
    }

    @DeleteMapping("/api/dolbomi/mypage/application")
    public ResponseEntity<String> deleteApplication(){
        String userId = FindUserInfo.getCurrentUserId();

        applicationService.deleteApplication(userId);

        return ResponseEntity.ok("지원서가 삭제되었습니다.");
    }

    @GetMapping("/api/dolbomi/mypage/carehistory")
    public ResponseEntity<List<ContractHistoryResponseDto>> getConractHistory(){
        String userId = FindUserInfo.getCurrentUserId();

        List<ContractHistoryResponseDto> dto = careHistoryService.getCareHistory(userId);

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/api/dolbmi/mypage/carehistory/{contractId}")
    public ResponseEntity<ContractResponseDto> getContract(@PathVariable int contractId){

        ContractResponseDto dto = careHistoryService.getContract(contractId);

        return ResponseEntity.ok(dto);
    }

}
