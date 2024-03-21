package com.example.ijoa_refactoring.service;

import com.example.ijoa_refactoring.data.dto.ContractHistoryResponseDto;
import com.example.ijoa_refactoring.data.dto.ContractResponseDto;
import com.example.ijoa_refactoring.data.entity.Contract;
import com.example.ijoa_refactoring.data.entity.Dolbomi;
import com.example.ijoa_refactoring.data.repository.ContractRepository;
import com.example.ijoa_refactoring.data.repository.DolbomiRepository;
import com.example.ijoa_refactoring.data.repository.ParentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CareHistoryService {

    private ContractRepository contractRepository;

    private DolbomiRepository dolbomiRepository;

    private ParentRepository parentRepository;

    public CareHistoryService(ContractRepository contractRepository,DolbomiRepository dolbomiRepository,ParentRepository parentRepository){
        this.contractRepository = contractRepository;
        this.dolbomiRepository = dolbomiRepository;
        this.parentRepository = parentRepository;
    }

    public List<ContractHistoryResponseDto> getCareHistory(String userId){
        Dolbomi dolbomi = dolbomiRepository.findByUserId(userId);
        int dolbomiId = dolbomi.getDolbomiId();
        List<Contract> historyList = contractRepository.findAllByDolbomiId(dolbomiId);

        List<ContractHistoryResponseDto> dtoList = historyList.stream()
                .map(contract -> {
                    ContractHistoryResponseDto dto = new ContractHistoryResponseDto();
                    dto.setStartDate(contract.getStartTime());
                    dto.setDolbomiName(dolbomi.getName());
                    dto.setCareType(contract.getCareType());
                    dto.setRegion(contract.getRegion());
                    dto.setStatement(contract.getPaymentState());

                    return dto;
                })
                .collect(Collectors.toList());

        return dtoList;
    }

    public ContractResponseDto getContract(int contractId){

        Contract contract = contractRepository.findByContractId(contractId);


        String dolbomiName = dolbomiRepository.findById(contract.getDolbomiId()).getName();
        String parentName = parentRepository.findById(contract.getParentId()).getName();

        ContractResponseDto dto = new ContractResponseDto();

        dto.setDolbomiName(dolbomiName);
        dto.setParentName(parentName);
        dto.setDay(contract.getDay());
        dto.setDate(contract.getDate());
        dto.setCareType(contract.getCareType());
        dto.setEndTime(contract.getEndTime());
        dto.setRegularity(contract.getRegularity());
        dto.setRegion(contract.getRegion());
        dto.setTotalCost(contract.getTotalCost());

        return dto;

    }
}
