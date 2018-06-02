package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("account-project/rest/account/")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping(value = "json", method = RequestMethod.GET)
    public List<Account> listAllAccounts() {
        return accountRepository.findAll();
    }


}
