package com.example.ijoa_refactoring.service;

import com.example.ijoa_refactoring.data.dto.ContractRegisterDto;
import com.example.ijoa_refactoring.data.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService {
    private ContractRepository contractRepository;

    @Autowired
    public ContractService(ContractRepository contractRepository){
        this.contractRepository = contractRepository;
    }

    public void registerContract(ContractRegisterDto contractRegisterDto){
        contractRepository.save(contractRegisterDto);
    }
}
