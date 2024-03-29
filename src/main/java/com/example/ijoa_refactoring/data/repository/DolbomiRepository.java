package com.example.ijoa_refactoring.data.repository;

import com.example.ijoa_refactoring.data.entity.Dolbomi;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DolbomiRepository extends JpaRepository<Dolbomi,Integer> {

    Dolbomi findByUserId(String userId);
    Dolbomi findById(int DolbomiId);
    Boolean existsByUserId(String id);

}
