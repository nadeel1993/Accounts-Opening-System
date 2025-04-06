package view.selector;

import java.util.Scanner;

public class AccountTypeSelector {

    public int selectAccount () {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please select the account type you want to create : \n" +
                "1 -> Savings Account" +
                "2 -> Fixed Deposit Account");

        int type = sc.nextInt();
        int returnType = 1;

        if (type == 2) {
            returnType = 2;
        } else if (type != 1){
            System.out.println("Invalid input. A savings account will be created.");
        }

        return returnType;
    }

}
