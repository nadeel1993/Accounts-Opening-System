package services.calculator;

import models.Account;

public class MaturityFDAccountInterestCalculator implements InterestCalculator {

    private Account account;

    public MaturityFDAccountInterestCalculator(Account account) {
        this.account = account;
    }

    @Override
    public double calculateTotalWithInterest() {
        double total = this.account.getBalance();
        int rotations = 0;
        while (rotations < this.account.getTimesPerYear()){
            total = total + total * this.account.getBalance();
            rotations++;
        }
        return total;
    }
}
