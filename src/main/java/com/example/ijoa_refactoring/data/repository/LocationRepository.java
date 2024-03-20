package com.example.ijoa_refactoring.data.repository;

import com.example.ijoa_refactoring.data.entity.Application;
import com.example.ijoa_refactoring.data.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Integer> {

    Location findByApplication(Application application);
}
