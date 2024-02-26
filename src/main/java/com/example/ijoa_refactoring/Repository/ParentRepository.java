package com.example.ijoa_refactoring.Repository;

import com.example.ijoa_refactoring.data.entity.Parent;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends JpaRepository<Parent,Integer> {
    @Transactional
    Parent save(Parent parent);
}
