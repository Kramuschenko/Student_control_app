package com.project.tin.backend.repository;

import com.project.tin.backend.Account;
import com.project.tin.backend.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query(value = "SELECT COALESCE((MAX(id) + 1), 1) FROM Account")
    Integer generateNextId();

    Account findByUsername(String username);
}
