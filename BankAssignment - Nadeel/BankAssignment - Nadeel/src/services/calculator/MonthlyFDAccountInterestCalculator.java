package services.calculator;

import models.Account;

public class MonthlyFDAccountInterestCalculator implements InterestCalculator{

    private Account account;

    public MonthlyFDAccountInterestCalculator(Account account) {
        this.account = account;
    }

    @Override
    public double calculateTotalWithInterest() {
        return this.account.getBalance() * this.account.getInterestRate() * 12.0 /100.0 + this.account.getBalance();
    }
}
