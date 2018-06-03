package com.example.demo.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountMock {

    private static Map<Long, Account> accounts = new HashMap<Long, Account>();
    private static Long idIndex = 3L;

    //populate initial accounts
    static {
        Account a = new Account(1L, "John", "Doe", "1234");
        accounts.put(1L, a);
        Account b = new Account(2L, "Jane", "Doe", "1235");
        accounts.put(2L, b);
        Account c = new Account(3L, "Jim", "Taylor", "1236");
        accounts.put(3L, c);
    }

    public static List<Account> list() {
        return new ArrayList<Account>(accounts.values());
    }

    public static Account create(Account account) {
        idIndex += idIndex;
        account.setId(idIndex);
        accounts.put(idIndex, account);
        return account;
    }

    public static Account get(Long id) {
        return accounts.get(id);
    }

    public static Account delete(Long id) {
        return accounts.remove(id);
    }
    
}
