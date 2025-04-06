package models.savings;

import models.Account;

public class ElderCitizenSavingsAccount extends Account {

    private static final double INTEREST_RATE = 5.0;

    public ElderCitizenSavingsAccount(String id, String firstName, String lastName, String dob, String address, double mobile) {
        super(id, firstName, lastName, dob, address, mobile);
    }

    public double getInterestRate() {
        return INTEREST_RATE;
    }
}
