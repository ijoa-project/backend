package com.example.ijoa_refactoring.data.repository;

import com.example.ijoa_refactoring.data.dto.ContractRegisterDto;
import com.example.ijoa_refactoring.data.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {
    Contract save(ContractRegisterDto contractRegisterDto);

    List<Contract> findAllByDolbomiId(int dolbomiId);

    Contract findByContractId(int contractId);

}
