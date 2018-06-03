package com.example.demo;

import com.example.demo.controller.AccountController;
import com.example.demo.model.Account;
import com.example.demo.model.MyResponse;
import com.example.demo.repository.AccountRepository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Any;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.hasToString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class AccountControllerTest {

    @InjectMocks
    private AccountController accountController;

    @Mock
    private AccountRepository accountRepository;

    @Before
    public void init(){
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

        when(accountController.listAccounts()).thenReturn(accountList);

        //Act
        List<Account> myAccountList = accountController.listAccounts();

        //Assert
        assertThat(myAccountList, hasSize(2));
    }

    @Test
    public void saveAccountToRepositoryTest() {
        //Arrange
        Account account = new Account();
        account.setId(2L);
        MyResponse myResponse = new MyResponse("account has been successfully added");

        //Act
        MyResponse mySaveResponse = accountController.addAccount(account);

        //Assert
        assertTrue(mySaveResponse.getMessage().contains(myResponse.getMessage()));
    }

    @Test
    public void deleteAnAccountFromRepositoryTest() {
        //Arrange
        Account account = new Account();
        account.setId(2L);
        MyResponse myResponse = new MyResponse("account successfully deleted");

        //Act
        MyResponse response = accountController.deleteAccount(2L);

        //Assert
        assertTrue(response.getMessage().contains(myResponse.getMessage()));
    }

}
