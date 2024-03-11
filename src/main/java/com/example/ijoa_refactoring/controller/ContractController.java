package com.example.ijoa_refactoring.controller;

import com.example.ijoa_refactoring.data.dto.ContractRegisterDto;
import com.example.ijoa_refactoring.service.ContractService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContractController {
    private ContractService contractService;

    public ContractController(ContractService contractService){
        this.contractService = contractService;
    }

    @PostMapping("/api/registerContract")
    public ResponseEntity<String> registerContract(@RequestBody ContractRegisterDto contractRegisterDto){
        contractService.registerContract(contractRegisterDto);
        return ResponseEntity.ok("확인서가 등록되었습니다.");
    }
}
