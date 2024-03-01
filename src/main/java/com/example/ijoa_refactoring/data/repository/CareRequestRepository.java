package com.example.ijoa_refactoring.data.Repository;

import com.example.ijoa_refactoring.data.dto.CareRequestDto;
import com.example.ijoa_refactoring.data.entity.CareRequest;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareRequestRepository extends JpaRepository<CareRequest,Integer> {
    @Transactional
    CareRequest save(CareRequestDto careRequestDto);

}