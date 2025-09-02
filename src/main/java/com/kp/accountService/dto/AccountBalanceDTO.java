package com.kp.accountService.dto;

import java.math.BigDecimal;

public record AccountBalanceDTO(
        Long accountId,
        String accountNumber,
        String accountHolderName,
        BigDecimal balance) {
}
