package com.kp.accountService.service;

import com.kp.accountService.AccountRepository;
import com.kp.accountService.dto.AccountBalanceDTO;
import com.kp.accountService.entity.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private  AccountRepository accountRepository;

    public Optional<AccountBalanceDTO> getAccountBalance(Long accountId) {
        return accountRepository.findById(accountId)
                .map(this::mapToBalanceDto);
    }

    private AccountBalanceDTO mapToBalanceDto(AccountEntity account) {
        return new AccountBalanceDTO(
                account.getId(),
                account.getAccountNumber(),
                account.getAccountHolderName(),
                account.getBalance()
        );
    }
}
