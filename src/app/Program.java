package app;

import entity.Account;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Account checkingAccountNewHolder = new Account();
        System.out.println(checkingAccountNewHolder);

        System.out.println();
        System.out.println("Do you want to make another transaction?");
        System.out.println("""
                                Type:\s
                                1 - Yes, I need to create a new account.\s
                                2 - Yes, I need to make a new withdrawal.\s
                                3 - Yes, I need to make a new deposit.\s
                                4 - No, exit.\s
                            """);
        String answer2 = sc.next();

        switch (answer2) {
            case "1" -> {
                Account newAccount1 = new Account();

                System.out.println(newAccount1);
            }
            case "2" -> {
                System.out.println();
                System.out.println("Enter withdraw value: ");
                double value = sc.nextDouble();
                checkingAccountNewHolder.accountWithdraw(value);

                System.out.println(checkingAccountNewHolder.accountData());
            }
            case "3" -> {
                System.out.println();
                System.out.println("Enter deposit value: ");
                double value = sc.nextDouble();
                checkingAccountNewHolder.accountDeposit(value);

                System.out.println(checkingAccountNewHolder.accountData());
            }
            case "4" -> {
                System.out.println("Ok, end of transaction.");

                break;
            }
            default -> throw new IllegalStateException("Unexpected value: " + answer2 + ", try again, do you want to make another transaction?");
        }
    }
}
