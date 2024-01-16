package com.project.tin.service;

import com.project.tin.backend.Account;
import com.project.tin.backend.repository.AccountRepository;
import com.project.tin.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.project.tin.frontend.UserController.setCurrentUser;

@Log4j2
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserService {

    private final AccountRepository accountRepository;
    public void registerUser(AccountDto userDto) {
        Account account = new Account();
        account.setId(accountRepository.generateNextId());
        account.setUsername(userDto.getUsername());
        account.setPassword(userDto.getPassword());
        account.setAdmin(userDto.getIsAdmin().equals("true"));

        accountRepository.save(account);
    }

    public boolean loginUser(AccountDto loginRequest) {
        Account account = accountRepository.findByUsername(loginRequest.getUsername());
        if (account != null) {
            boolean equals = account.getPassword().equals(loginRequest.getPassword());
            if (equals) {
                setCurrentUser(account);
                log.info("User {} logged in", loginRequest.getUsername());
            } else {
                log.info("User {} failed to log in", loginRequest.getUsername());
            }
            return equals;
        } else {
            return false;
        }
    }
}