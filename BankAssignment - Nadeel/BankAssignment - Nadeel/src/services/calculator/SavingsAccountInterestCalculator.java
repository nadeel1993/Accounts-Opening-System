package services.calculator;

import models.Account;

public class SavingsAccountInterestCalculator implements InterestCalculator  {

    private Account account;

    public SavingsAccountInterestCalculator(Account account) {
        this.account = account;
    }

    @Override
    public double calculateTotalWithInterest() {
        return this.account.getBalance() * this.account.getInterestRate() / 100.0 + this.account.getBalance();
    }
}
