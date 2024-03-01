package com.example.ijoa_refactoring.data.repository;

import com.example.ijoa_refactoring.data.entity.Parent;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Integer> {
    Parent findById(String userId);
    @Transactional
    Parent save(Parent parent);
}
