package models.savings;

import models.Account;

public class GeneralSavingsAccount extends Account {

    private static final double INTEREST_RATE = 4.0;

    public GeneralSavingsAccount(String id, String firstName, String lastName, String dob, String address, double balance) {
        super(id, firstName, lastName, dob, address, balance);
    }

    public double getInterestRate() {
        return INTEREST_RATE;
    }
}
