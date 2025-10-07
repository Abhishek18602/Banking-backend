package com.Bank.Banking.service;

import com.Bank.Banking.dto.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(Long id);
    AccountDto deposit(Long id, double amount);
    AccountDto withdraw(Long id, double amount);

    List<AccountDto> getAllAccount();
    void deleteAccount(Long id);
}
