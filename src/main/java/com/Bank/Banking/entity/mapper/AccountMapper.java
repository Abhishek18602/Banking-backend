package com.Bank.Banking.entity.mapper;

import com.Bank.Banking.dto.AccountDto;
import com.Bank.Banking.entity.Account;

public class AccountMapper {
    public  static Account mapToAccount(AccountDto accountDto)
    {
        Account account=new Account(
                accountDto.id(),
                accountDto.accountHolderName(),
                accountDto.balance()
        );
        return  account;
    }

    public  static AccountDto mapToAccountDto(Account account)
    {
        AccountDto accountDto=new AccountDto(
                account.getId(),
                account.getAccountHolder(),
                account.getBalance()
        );
        return  accountDto;
    }
}
