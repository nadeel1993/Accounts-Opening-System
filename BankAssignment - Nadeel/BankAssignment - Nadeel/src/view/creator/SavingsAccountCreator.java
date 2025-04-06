package view.creator;

import models.Account;
import models.savings.ElderCitizenSavingsAccount;
import models.savings.GeneralSavingsAccount;
import models.savings.WanithaSavingsAccount;
import repository.AccountRepository;
import validators.SavingsAccountValidator;

import java.util.Scanner;

public class SavingsAccountCreator implements AccountCreator {

    private static AccountRepository accountRepository = new AccountRepository();

    /**
     *
     * @param id
     * @param firstName
     * @param lastName
     * @param dob
     * @param address
     * @return
     * @throws Exception
     */
    @Override
    public Account createAccount(String id, String firstName, String lastName, String dob, String address, double amount) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the savings account type you want to create : \n" +
                "1 -> General Savings Account\n" +
                "2 -> Elder Citizen Savings Account\n" +
                "3 -> Wanitha Savings Account");

        int accountType = sc.nextInt();

        Account account;
        switch (accountType) {
            case 1 -> account = new GeneralSavingsAccount(id, firstName, lastName, dob, address, amount);
            case 2 -> account = new ElderCitizenSavingsAccount(id, firstName, lastName, dob, address, amount);
            case 3 -> account = new WanithaSavingsAccount(id, firstName, lastName, dob, address, amount);
            default -> {
                System.out.println("Invalid input. A general account will be created with the given information.");
                account = new GeneralSavingsAccount(id, firstName, lastName, dob, address, amount);
            }
        }

        if (new SavingsAccountValidator().validate(account)) {
            accountRepository.createAccount(account);
        } else {
            System.out.println("Cannot create the account. Please credit sufficient funds to start.");
            throw new Exception("Cannot create the account. Please credit sufficient funds to start.");
        }

        return account;
    }

}
