package com.example.ijoa_refactoring.data.repository;

import com.example.ijoa_refactoring.data.dto.AccountRegisterDto;
import com.example.ijoa_refactoring.data.entity.Account;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Transactional
    Account save(AccountRegisterDto accountRegisterDto);
}
