package com.Bank.Banking.service.impl;

import com.Bank.Banking.dto.AccountDto;
import com.Bank.Banking.entity.Account;
import com.Bank.Banking.entity.mapper.AccountMapper;
import com.Bank.Banking.exception.AccountException;
import com.Bank.Banking.repository.AccountRepository;
import com.Bank.Banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Autowired
    AccountServiceImpl(AccountRepository accountRepository1){
        this.accountRepository=accountRepository1;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto((savedAccount));
    }

    @Override
    public AccountDto getAccountById(Long id) {
       Account acccount= accountRepository
                        .findById(id)
                        .orElseThrow(()->new AccountException("Account does not exists"));

        return AccountMapper.mapToAccountDto(acccount);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account= accountRepository
                        .findById(id)
                        .orElseThrow(()->new AccountException("Account Id does not exist"));

        double total =  account.getBalance()+amount;
        account.setBalance(total);
        Account savedAccount =  accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account=accountRepository.findById(id).orElseThrow(()->new AccountException("Account does not exist"));
        double total=account.getBalance()-amount;
        if(account.getBalance()<amount)
        {
            throw  new AccountException("Insufficient Balance");
        }

        if(total<0)
        {
            total=0;
        }
        account.setBalance(total);

        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);

    }

    @Override
    public List<AccountDto> getAllAccount() {
        List<Account> accounts=accountRepository.findAll();
        return accounts.stream().map(AccountMapper::mapToAccountDto).toList();
    }

    @Override
    public void deleteAccount(Long id) {
        Account account=accountRepository.findById(id)
                .orElseThrow(()->new AccountException("Does not exist "));

        accountRepository.deleteById(id);
    }
}

