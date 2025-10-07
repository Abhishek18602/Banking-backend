package com.Bank.Banking.controller;

import com.Bank.Banking.dto.AccountDto;
import com.Bank.Banking.entity.Account;
import com.Bank.Banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;

    public  AccountController(AccountService accountService1)
    {
        this.accountService=accountService1;
    }

//    Add  Account REST API
    @PostMapping()
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

//    get account REST API
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountbyId(@PathVariable Long id)
    {
        AccountDto accountDto=accountService.getAccountById(id);
        return  ResponseEntity.ok(accountDto);
    }

//    deposit REST API
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request)
    {
        Double amount=request.get("amount");

        AccountDto accountDto = accountService.deposit(id, request.get("amount"));
        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request)
    {
        Double amount=request.get("amount");
        AccountDto accountDto=accountService.withdraw(id, request.get("amount"));
        return  ResponseEntity.ok(accountDto);
    }

    @GetMapping()
    public  ResponseEntity<List<AccountDto>> allAccounts()
    {
      List<AccountDto> accountDto=accountService.getAllAccount();
        return  ResponseEntity.ok(accountDto);
    }


    @DeleteMapping("{id}")
    public  ResponseEntity<String> deleteAccount(@PathVariable Long id)
    {
        accountService.deleteAccount(id);
        return   ResponseEntity.ok("Deleted Successfully");
    }

}
