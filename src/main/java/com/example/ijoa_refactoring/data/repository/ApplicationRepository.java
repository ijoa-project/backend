package com.example.ijoa_refactoring.data.repository;

import com.example.ijoa_refactoring.data.entity.Application;
import com.example.ijoa_refactoring.data.entity.Dolbomi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    Application findByDolbomi(Dolbomi dolbomi);
}
