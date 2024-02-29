package com.example.ijoa_refactoring.data.repository;

import com.example.ijoa_refactoring.data.entity.Dolbomi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DolbomiRepository extends JpaRepository<Dolbomi,Long> {

    Dolbomi findById(String userId);
}
