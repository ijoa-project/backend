package com.example.ijoa_refactoring.service;

import com.example.ijoa_refactoring.data.dto.ContractRegisterDto;
import com.example.ijoa_refactoring.data.entity.Contract;
import com.example.ijoa_refactoring.data.entity.Parent;
import com.example.ijoa_refactoring.data.repository.CareRequestRepository;
import com.example.ijoa_refactoring.data.repository.ContractRepository;
import com.example.ijoa_refactoring.data.repository.DolbomiRepository;
import com.example.ijoa_refactoring.data.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService {
    private ContractRepository contractRepository;
    private CareRequestRepository careRequestRepository;
    private DolbomiRepository dolbomiRepository;
    private ParentRepository parentRepository;

    @Autowired
    public ContractService(ContractRepository contractRepository, CareRequestRepository careRequestRepository,
                           DolbomiRepository dolbomiRepository, ParentRepository parentRepository){

        this.contractRepository = contractRepository;
        this.careRequestRepository = careRequestRepository;
        this.dolbomiRepository = dolbomiRepository;
        this.parentRepository = parentRepository;
    }

    public void registerContract(ContractRegisterDto contractRegisterDto){
        Contract contract = new Contract();
        contract.setCareRequest(careRequestRepository.findById(contractRegisterDto.getCareRequestId()));
        contract.setDolbomi(dolbomiRepository.findById(contractRegisterDto.getDolbomiId()));
        contract.setParent(parentRepository.findById(contractRegisterDto.getParentId()));
        contract.setCareType(contractRegisterDto.getCareType());
        contract.setStartDate(contractRegisterDto.getStartDate());
        contract.setEndDate(contractRegisterDto.getEndDate());
        contract.setStartTime(contractRegisterDto.getStartTime());
        contract.setEndTime(contractRegisterDto.getEndTime());
        contract.setRegion(contractRegisterDto.getRegion());
        contract.setRegularity(contractRegisterDto.getRegularity());
        contract.setTotalCost(contractRegisterDto.getTotalCost());
        contractRepository.save(contract);
    }
}
