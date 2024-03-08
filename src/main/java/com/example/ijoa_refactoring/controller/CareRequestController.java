package com.example.ijoa_refactoring.controller;

import com.example.ijoa_refactoring.data.dto.CareRequestDto;
import com.example.ijoa_refactoring.data.entity.CareRequest;
import com.example.ijoa_refactoring.service.CareRequestService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CareRequestController {
    private CareRequestService careRequestService;

    public CareRequestController(CareRequestService careRequestService){
        this.careRequestService = careRequestService;
    }

    @PostMapping("/api/registerCareRequest")
    public ResponseEntity<String> registerCareRequest(@RequestBody CareRequestDto careRequestDto){
        careRequestService.registerCareRequest(careRequestDto);
        return ResponseEntity.ok("돌봄요청이 정상적으로 등록되었습니다.");
    }

    @GetMapping("/api/findCareRequest/{careRequestId}")
    public ResponseEntity<CareRequest> findCareRequest(@PathVariable int careRequestId){
        CareRequest careRequest = careRequestService.findCareRequest(careRequestId);
        return ResponseEntity.ok(careRequest);
    }

    @PostMapping("/api/updateCareRequest/{careRequestId}")
    public ResponseEntity<String> updateCareRequest(@PathVariable int careRequestId,
            @RequestBody CareRequestDto careRequestDto){
        careRequestService.updateCareRequest(careRequestId, careRequestDto);
        return ResponseEntity.ok("돌봄요청이 수정되었습니다.");
    }

    @DeleteMapping("/api/deleteCareRequest/{careRequestId}")
    public ResponseEntity<String> deleteCareRequest(@PathVariable int careRequestId){
        careRequestService.deleteCareRequest(careRequestId);
        return ResponseEntity.ok("돌봄요청이 삭제되었습니다.");
    }

    @GetMapping("/api/careRequestList")
    public ResponseEntity<String> list(@RequestParam(value="page", defaultValue="0") int page) {
        Page<CareRequest> paging = careRequestService.getList(page);
        return ResponseEntity.ok("돌봄요청 리스트 출력");
    }
}
