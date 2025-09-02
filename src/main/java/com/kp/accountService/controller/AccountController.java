package com.kp.accountService.controller;

import com.kp.accountService.dto.AccountBalanceDTO;
import com.kp.accountService.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/{accountId}/balance")
    public ResponseEntity<AccountBalanceDTO> getAccountBalance(@PathVariable Long accountId) {
        return accountService.getAccountBalance(accountId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
