package com.example.quiz3.Service;

import com.example.quiz3.Api.ApiException;
import com.example.quiz3.Model.Account;
import com.example.quiz3.Model.Customer;
import com.example.quiz3.Model.User;
import com.example.quiz3.Repository.AccountRepository;
import com.example.quiz3.Repository.AuthRepository;
import com.example.quiz3.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
   private final CustomerRepository customerRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll(); // auth(customer,admin)
    }

    public Account getAccountById(Integer id) {
        return accountRepository.findAccountById(id);
    }

    public Account createAccount(Integer customer_id,Account account) {
       Customer customer =customerRepository.findCustomerById(customer_id);
        if(customer==null){
            throw new ApiException("Customer not found");
        }
        Account account1=new Account();
        account1.setAccountNumber(account.getAccountNumber());
        account1.setBalance(account.getBalance());
        account1.setActive(account.isActive());
        return accountRepository.save(account1);
    }

    public void deposit(Integer account_id,Integer amount) {
        Account account = accountRepository.findAccountById(account_id);
        if(account==null){
            throw new ApiException("Account not found");
        }
        if(account.getBalance()<amount){
            throw new ApiException(" balance not enough");
        }
        account.setBalance(account.getBalance()+amount);
        accountRepository.save(account);
    }

    public void withdraw(Integer account_id,Integer amount) {
        Account account = accountRepository.findAccountById(account_id);
        if(account==null){
            throw new ApiException("Account not found");
        }
        if(account.getBalance()<amount){
            throw new ApiException(" balance not enough");
        }
        account.setBalance(account.getBalance()-amount);
        accountRepository.save(account);

    }

    public void transfer(Integer fromAccount,Integer toAccount,Integer account_id,Integer amount) {
        Account account = accountRepository.findAccountById(account_id);
        if(account==null){
            throw new ApiException("Account not found");
        }
        Customer customer =customerRepository.findCustomerById(fromAccount);
        if(customer==null){
            throw new ApiException("Customer not found");
        }
        Customer customer1=customerRepository.findCustomerById(toAccount);
        if(customer1==null){
            throw new ApiException("Customer not found");
        }
        if(account.getBalance()<amount){
            throw new ApiException(" balance not enough");
        }





        customerRepository.save(customer);
        accountRepository.save(account);
    }


}
