package com.example.ijoa_refactoring.data.repository;

import com.example.ijoa_refactoring.data.entity.Dolbomi;
import com.example.ijoa_refactoring.data.entity.DolbomiAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DolbomiAuthRepository extends JpaRepository<DolbomiAuth, Integer> {
    DolbomiAuth findByDolbomi(Dolbomi dolbomi);



}
