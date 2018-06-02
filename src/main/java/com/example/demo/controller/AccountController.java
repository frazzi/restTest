package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.model.MyResponse;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account-project/rest/account/")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping(value = "json", method = RequestMethod.GET)
    public List<Account> listAccounts() {
        return accountRepository.findAll();
    }


    @RequestMapping(value = "json", method = RequestMethod.POST)
    public MyResponse addAccount(@RequestBody Account account) {
        MyResponse response= null;
        if (account != null) {
            Account user = accountRepository.save(account);
            response = new MyResponse("account has been successfully added");
        }

        return response;
    }

    @RequestMapping(value = "json/{id}", method = RequestMethod.DELETE)
    public MyResponse deleteAccount(@PathVariable Long id) {
        MyResponse response= null;
        if (id != null) {
            accountRepository.deleteById(id);
            response = new MyResponse("account successfully deleted");
        }

        return response;
    }
}
