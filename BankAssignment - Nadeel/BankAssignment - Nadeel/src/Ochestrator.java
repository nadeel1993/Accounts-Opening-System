import models.Account;
import models.fixed.monthly.TwelveMonthFDMonthlyAccount;
import repository.AccountRepository;
import services.calculator.InterestCalculator;
import services.calculator.MaturityFDAccountInterestCalculator;
import services.calculator.MonthlyFDAccountInterestCalculator;
import services.calculator.SavingsAccountInterestCalculator;
import view.creator.AccountCreator;
import view.creator.FDAccountCreator;
import view.creator.SavingsAccountCreator;
import view.selector.AccountTypeSelector;

import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

public class Ochestrator {

    public static void main(String[] args) {

        System.out.println("Welcome to XYZ ");
        Scanner sc = new Scanner(System.in);
        boolean shouldContinue = true;
        while (shouldContinue) {
            Account account;
            InterestCalculator interestCalculator;
            AccountTypeSelector accountTypeSelector = new AccountTypeSelector();
            int type = accountTypeSelector.selectAccount();
            AccountCreator accountCreator;
            if(type == 1){
                accountCreator = new SavingsAccountCreator();
            } else {
                accountCreator = new FDAccountCreator();
            }
            System.out.println("Please enter the first name : ");
            String firstName = sc.nextLine();
            System.out.println("Please enter the last name : ");
            String lastName = sc.nextLine();
            System.out.println("Please enter the dob : ");
            String dob = sc.nextLine();
            System.out.println("Please enter the address : ");
            String address = sc.nextLine();

            System.out.println("Please enter the initial depositing amount : ");
            double amount = sc.nextDouble();

            System.out.println("Please wait until the account is created.");
            String id = generateId();
            try{
                account = accountCreator.createAccount(id, firstName, lastName, dob, address, amount);
                if(type == 1) {
                    interestCalculator = new SavingsAccountInterestCalculator(account);
                } else {
                    if(account instanceof TwelveMonthFDMonthlyAccount){
                        interestCalculator = new MonthlyFDAccountInterestCalculator(account);
                    }
                    interestCalculator = new MaturityFDAccountInterestCalculator(account);
                }
                System.out.println("SUCCESS! : Account is created. Your account ID is : ".concat(id));
                System.out.println("Your account would have ".concat(Double.toString(interestCalculator.calculateTotalWithInterest())).concat("RS in total."));
                AccountRepository accountRepository = new AccountRepository();
                accountRepository.createAccount(account);
                System.out.println("Do you wish to continue and create another account ? ");
                String character = sc.nextLine();
                if(character.startsWith("y") || character.startsWith("Y")){
                    continue;
                } else {
                    shouldContinue = false;
                }
            } catch (Exception e) {
                System.out.println("ERROR! : amount is insufficient. Please try again.");
            }


        }

    }

    public static String generateId () {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, StandardCharsets.UTF_8);
        return generatedString;
    }

}