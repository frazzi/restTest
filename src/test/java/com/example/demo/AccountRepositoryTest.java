package com.example.demo;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.hasToString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class AccountRepositoryTest {

    @Mock
    private AccountRepository accountRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAllAccountsFromRepositoryTest() {
        //Arrange
        Account account1 = new Account();
        account1.setId(1L);
        Account account2 = new Account();
        account2.setId(2L);

        List<Account> accountList = new ArrayList<>();
        accountList.add(account1);
        accountList.add(account2);

        when(accountRepository.findAll()).thenReturn(accountList);

        //Act
        List<Account> myAccountList = accountRepository.findAll();

        //Assert
        assertThat(myAccountList, hasSize(2));
    }

    @Test
    public void saveAccountToRepositoryTest() {
        //Arrange
        Account account = new Account();
        account.setId(2L);

        when(accountRepository.save(account)).thenReturn(account);

        //Act
        Account mySavedAccount = accountRepository.save(account);

        //Assert
        assertThat(mySavedAccount, hasToString(account.toString()));
    }

    @Test
    public void deleteAnAccountFromRepositoryTest() {
        //Arrange
        Account account = new Account();
        account.setId(2L);

        doNothing().when(accountRepository).deleteById(2L);

        //Act
        accountRepository.deleteById(2L);
    }

}
