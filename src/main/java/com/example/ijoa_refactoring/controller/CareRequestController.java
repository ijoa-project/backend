package com.example.ijoa_refactoring.controller;

import com.example.ijoa_refactoring.data.dto.CareRequestRequestDto;
import com.example.ijoa_refactoring.data.dto.SearchRequestDto;
import com.example.ijoa_refactoring.data.entity.CareRequest;
import com.example.ijoa_refactoring.service.CareRequestService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CareRequestController {
    private CareRequestService careRequestService;

    public CareRequestController(CareRequestService careRequestService){
        this.careRequestService = careRequestService;
    }

    @PostMapping("/api/registerCareRequest")
    public ResponseEntity<String> registerCareRequest(@RequestBody CareRequestRequestDto careRequestDto){
        careRequestService.registerCareRequest(careRequestDto);
        return ResponseEntity.ok("돌봄요청이 정상적으로 등록되었습니다.");
    }

    @GetMapping("/api/findCareRequest/{careRequestId}")
    public ResponseEntity<CareRequest> findCareRequest(@PathVariable int careRequestId){
        CareRequest careRequest = careRequestService.findCareRequest(careRequestId);
        return ResponseEntity.ok(careRequest);
    }

    @PutMapping("/api/updateCareRequest/{careRequestId}")
    public ResponseEntity<String> updateCareRequest(@PathVariable int careRequestId,
            @RequestBody CareRequestRequestDto careRequestDto){
        careRequestService.updateCareRequest(careRequestId, careRequestDto);
        return ResponseEntity.ok("돌봄요청이 수정되었습니다.");
    }

    @DeleteMapping("/api/deleteCareRequest/{careRequestId}")
    public ResponseEntity<String> deleteCareRequest(@PathVariable int careRequestId){
        careRequestService.deleteCareRequest(careRequestId);
        return ResponseEntity.ok("돌봄요청이 삭제되었습니다.");
    }

    @GetMapping("/api/careRequestList")
    public ResponseEntity<Page<CareRequest>> list(@RequestParam(value="page", defaultValue="0") int page) {
        Page<CareRequest> paging = careRequestService.getList(page);
        return ResponseEntity.ok(paging);
    }

    @GetMapping("/api/search")
    public ResponseEntity<List<CareRequest>> search(@RequestBody SearchRequestDto searchRequestDto){
        List<CareRequest> list = careRequestService.search(searchRequestDto);
        return ResponseEntity.ok(list);
    }
}
