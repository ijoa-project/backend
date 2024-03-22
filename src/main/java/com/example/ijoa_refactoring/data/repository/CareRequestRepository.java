package com.example.ijoa_refactoring.data.repository;

import com.example.ijoa_refactoring.data.dto.CareRequestRequestDto;
import com.example.ijoa_refactoring.data.dto.SearchRequestDto;
import com.example.ijoa_refactoring.data.entity.CareRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CareRequestRepository extends JpaRepository<CareRequest,Integer> {
    @Transactional
    CareRequest save(CareRequestRequestDto careRequestDto);
    CareRequest findById(int careRequestId);
    CareRequest deleteById(int careRequestId);



    @Override
    Page<CareRequest> findAll(Pageable pageable);


}
