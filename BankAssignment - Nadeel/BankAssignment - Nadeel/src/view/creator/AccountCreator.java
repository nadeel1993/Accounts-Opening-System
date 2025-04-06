package view.creator;

import models.Account;

public interface AccountCreator {
    public Account createAccount(String id, String firstName, String lastName, String dob, String address, double amount) throws Exception;
}
