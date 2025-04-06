package validators;

import models.Account;

public class FDAccountValidator {

    private static final double MINIMUM_DEPOSIT = 25000.0;

    public boolean validate(Account account) {
        return account.getBalance() >= MINIMUM_DEPOSIT;
    }

}
