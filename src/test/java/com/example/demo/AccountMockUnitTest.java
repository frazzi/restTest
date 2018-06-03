package com.example.demo;

import com.example.demo.controller.AccountController;
import com.example.demo.model.Account;
import com.example.demo.model.AccountMock;
import com.example.demo.repository.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.samePropertyValuesAs;

public class AccountMockUnitTest {

    @Test
    public void listOfAccountsHasThreeAccountsTest() {
        //Arrange
        AccountMock accountMock = new AccountMock();

        //Act
        List<Account> accountList = accountMock.list();

        //Assert
        assertThat(accountList, hasSize(3));

    }

    @Test
    public void addAnotherAccountTest() {
        //Arrange
        AccountMock accountMock = new AccountMock();
        Account account = new Account(3L, "Steven", "Doe", "1237");

        //Act
        List<Account> accountList = accountMock.list();
        accountList.add(account);

        //Assert
        assertThat(accountList, hasSize(4));
        assertThat(accountList.get(3), samePropertyValuesAs(account));
    }

    @Test
    public void deleteAnAccountTest() {
        //Arrange
        AccountMock accountMock = new AccountMock();

        //Act
        List<Account> accountList = accountMock.list();

        //Assert
        assertThat(accountList, hasSize(3));

        //Act
        accountList.remove(1);

        //Assert
        assertThat(accountList, hasSize(2));

    }
}
