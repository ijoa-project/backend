package com.example.ijoa_refactoring.service;

import com.example.ijoa_refactoring.data.repository.CareRequestRepository;
import com.example.ijoa_refactoring.data.dto.CareRequestDto;
import com.example.ijoa_refactoring.data.entity.CareRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CareRequestService {
    private CareRequestRepository careRequestRepository;

    @Autowired
    public CareRequestService(CareRequestRepository careRequestRepository){
        this.careRequestRepository = careRequestRepository;
    }

    public void registerCareRequest(CareRequestDto careRequestDto){
        CareRequest careRequest = new CareRequest();
        careRequest.setCareType(careRequestDto.getCareType());
        careRequest.setDay(careRequest.getDay());
        careRequest.setRegularity(careRequestDto.getRegularity());
        careRequest.setChildGender(careRequestDto.getChildGender());
        careRequest.setChildAge(careRequestDto.getChildAge());
        careRequest.setStartDate(careRequestDto.getStartDate());
        careRequest.setEndDate(careRequestDto.getEndDate());
        careRequest.setRegion(careRequestDto.getRegion());
        careRequest.setTitle(careRequestDto.getTitle());
        careRequest.setContent(careRequestDto.getContent());
        careRequest.setState(0);
        careRequestRepository.save(careRequest);
    }

    public CareRequest findCareRequest(int careRequestId){
        CareRequest careRequest = careRequestRepository.findById(careRequestId);
        return careRequest;
    }

    public void updateCareRequest(int careRequestId, CareRequestDto careRequestDto){
        CareRequest careRequest = careRequestRepository.findById(careRequestId);
        careRequest.setCareType(careRequestDto.getCareType());
        careRequest.setDay(careRequest.getDay());
        careRequest.setRegularity(careRequestDto.getRegularity());
        careRequest.setChildGender(careRequestDto.getChildGender());
        careRequest.setChildAge(careRequestDto.getChildAge());
        careRequest.setStartDate(careRequestDto.getStartDate());
        careRequest.setEndDate(careRequestDto.getEndDate());
        careRequest.setRegion(careRequestDto.getRegion());
        careRequest.setTitle(careRequestDto.getTitle());
        careRequest.setContent(careRequestDto.getContent());
        careRequestRepository.save(careRequest);
    }

    public void deleteCareRequest(int careRequestId){
        careRequestRepository.deleteById(careRequestId);
    }
}
