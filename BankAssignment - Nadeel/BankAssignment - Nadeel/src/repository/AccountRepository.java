package repository;

import models.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository {

    private static final List<Account> accounts = new ArrayList<>();

    public Account createAccount (Account account) {
        accounts.add(account);
        return account;
    }

    public List<Account> getAllAccounts () {
        return accounts;
    }
}
