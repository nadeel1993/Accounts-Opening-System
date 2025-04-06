package validators;

import models.Account;

public class SavingsAccountValidator {

    private static final double MINIMUM_DEPOSIT = 1000.0;

    public boolean validate(Account account) {
        return account.getBalance() >= MINIMUM_DEPOSIT;
    }

}
