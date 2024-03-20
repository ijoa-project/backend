package com.example.ijoa_refactoring.controller;

import com.example.ijoa_refactoring.auth.FindUserInfo;
import com.example.ijoa_refactoring.data.dto.ApplicationRequestDto;
import com.example.ijoa_refactoring.data.dto.ApplicationResponseDto;
import com.example.ijoa_refactoring.data.entity.Application;
import com.example.ijoa_refactoring.service.ApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DolbomiController {

    private ApplicationService applicationService;

    public DolbomiController(ApplicationService applicationService){
        this.applicationService = applicationService;
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

}
