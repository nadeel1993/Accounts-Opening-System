package models.fixed.monthly;

import models.Account;

public class TwelveMonthFDMonthlyAccount  extends Account {

    private final double INTEREST_RATE = 6.5;
    private final int TIMES_PER_YEAR = 2;

    public TwelveMonthFDMonthlyAccount(String id, String firstName, String lastName, String dob, String address, double balance) {
        super(id, firstName, lastName, dob, address, balance);
    }

    public double getInterestRate() {
        return INTEREST_RATE;
    }

    public int getTimesPerYear() {
        return TIMES_PER_YEAR;
    }

}
