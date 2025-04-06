package view.creator;

import models.Account;
import models.fixed.SixMonthsFDAccount;
import models.fixed.ThreeMonthFDAccount;
import models.fixed.TwelveMonthsFDAccount;
import models.fixed.monthly.TwelveMonthFDMonthlyAccount;
import repository.AccountRepository;
import validators.FDAccountValidator;

import java.util.Scanner;

public class FDAccountCreator implements AccountCreator {

    private static AccountRepository accountRepository = new AccountRepository();

    @Override
    public Account createAccount(String id, String firstName, String lastName, String dob, String address, double amount) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the fixed deposit account type you want to create : \n" +
                "1 -> Three Months FD Account\n" +
                "2 -> Six Months FD Account\n" +
                "3 -> Twelve Months FD Account\n" +
                "4 -> Twelve Months FD Monthly Account");

        int accountType = sc.nextInt();

        Account account;
        switch (accountType) {
            case 1 -> account = new ThreeMonthFDAccount(id, firstName, lastName, dob, address, amount);
            case 2 -> account = new SixMonthsFDAccount(id, firstName, lastName, dob, address, amount);
            case 3 -> account = new TwelveMonthsFDAccount(id, firstName, lastName, dob, address, amount);
            case 4 -> account = new TwelveMonthFDMonthlyAccount(id, firstName, lastName, dob, address, amount);
            default -> {
                System.out.println("Invalid input. A three month FD account will be created with the given information.");
                account = new ThreeMonthFDAccount(id, firstName, lastName, dob, address, amount);
            }
        }

        if (new FDAccountValidator().validate(account)) {
            accountRepository.createAccount(account);
        } else {
            System.out.println("Cannot create the account. Please credit sufficient funds to start.");
            throw new Exception("Cannot create the account. Please credit sufficient funds to start.");
        }

        return account;
    }
}
