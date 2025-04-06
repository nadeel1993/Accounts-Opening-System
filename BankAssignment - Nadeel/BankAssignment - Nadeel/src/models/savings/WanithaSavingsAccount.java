package models.savings;

import models.Account;

public class WanithaSavingsAccount extends Account {

    private static final double INTEREST_RATE = 4.5;

    public WanithaSavingsAccount(String id, String firstName, String lastName, String dob, String address, double amount) {
        super(id, firstName, lastName, dob, address, amount);
    }

    public double getInterestRate() {
        return INTEREST_RATE;
    }
}
