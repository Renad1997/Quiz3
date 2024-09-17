package com.example.quiz3.Controller;

import com.example.quiz3.Model.Account;
import com.example.quiz3.Service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/get")
    public ResponseEntity getAllAccounts() {
        return ResponseEntity.status(200).body(accountService.getAllAccounts());

    }

    @GetMapping("/get/account")
    public ResponseEntity getAccountById(Integer id) {
        return ResponseEntity.status(200).body(accountService.getAccountById(id));
    }

    @PostMapping("/add/{customer_id}")
    public ResponseEntity createAccount(@PathVariable Integer customer_id,@Valid @RequestBody Account account) {
        return ResponseEntity.status(200).body(accountService.createAccount(customer_id,account));
    }

    @GetMapping("/{account_id}/deposit/{amount}")
    public ResponseEntity deposit(@PathVariable Integer account_id,@PathVariable Integer amount) {
       return ResponseEntity.status(200).body(deposit(account_id,amount));
    }
    @GetMapping("/withdrawal/{account_id}/{amount}")
    public ResponseEntity withdrawal(@PathVariable Integer account_id,@PathVariable Integer amount) {
        return ResponseEntity.status(200).body(withdrawal(account_id,amount));
    }
}
