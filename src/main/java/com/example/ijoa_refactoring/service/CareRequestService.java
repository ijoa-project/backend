package com.example.ijoa_refactoring.service;

import com.example.ijoa_refactoring.data.dto.SearchRequestDto;
import com.example.ijoa_refactoring.data.repository.CareRequestRepository;
import com.example.ijoa_refactoring.data.dto.CareRequestRequestDto;
import com.example.ijoa_refactoring.data.entity.CareRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CareRequestService {
    private CareRequestRepository careRequestRepository;
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    public CareRequestService(CareRequestRepository careRequestRepository){
        this.careRequestRepository = careRequestRepository;
    }

    public void registerCareRequest(CareRequestRequestDto careRequestDto){
        CareRequest careRequest = new CareRequest();
        careRequest.setCareType(careRequestDto.getCareType());
        careRequest.setDay(careRequest.getDay());
        careRequest.setRegularity(careRequestDto.getRegularity());
        careRequest.setChildGender(careRequestDto.getChildGender());
        careRequest.setChildAge(careRequestDto.getChildAge());
        careRequest.setDate(careRequestDto.getDate());
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

    public void updateCareRequest(int careRequestId, CareRequestRequestDto careRequestDto){
        CareRequest careRequest = careRequestRepository.findById(careRequestId);
        careRequest.setCareType(careRequestDto.getCareType());
        careRequest.setDay(careRequest.getDay());
        careRequest.setRegularity(careRequestDto.getRegularity());
        careRequest.setChildGender(careRequestDto.getChildGender());
        careRequest.setChildAge(careRequestDto.getChildAge());
        careRequest.setDate(careRequestDto.getDate());
        careRequest.setRegion(careRequestDto.getRegion());
        careRequest.setTitle(careRequestDto.getTitle());
        careRequest.setContent(careRequestDto.getContent());
        careRequestRepository.save(careRequest);
    }

    public void deleteCareRequest(int careRequestId){
        careRequestRepository.deleteById(careRequestId);
    }

    public Page<CareRequest> getList(int page){
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("careRequestId"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return careRequestRepository.findAll(pageable);
    }

    public List<CareRequest> search(SearchRequestDto searchRequestDto){
        String jpql = "SELECT cr FROM CareRequest cr " +
                "WHERE cr.regularity in :regularity " +
                "AND cr.day in :day " +
                "AND cr.careType in :careType";

        TypedQuery<CareRequest> query = entityManager.createQuery(jpql, CareRequest.class);
        query.setParameter("regularity", searchRequestDto.getRegularity());
        query.setParameter("day", searchRequestDto.getDay());
        query.setParameter("careType", searchRequestDto.getCareType());
        List<CareRequest> list = query.getResultList();
        List<CareRequest> returnList = new ArrayList<>();
        for(CareRequest careRequest : list){
            String[] address = careRequest.getRegion().split(" ");
            if(address[0].equals(searchRequestDto.getSi())&&
            searchRequestDto.getGu().contains(address[1])){
                returnList.add(careRequest);
            }
        }
        return returnList;
    }
}
