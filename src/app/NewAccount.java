package app;

import entity.Account;

import java.util.Scanner;

public class NewAccount {
    Scanner sc = new Scanner(System.in);

    public int number;
    public String holder;
    public String answer;

    public int getNumber() {
        return number;
    }

    public void setNumber() {
        this.number = sc.nextInt();
    }
    public String getHolder() {
        return holder;
    }

    public void setHolder() {
        this.holder = sc.next();
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {

        System.out.print("Enter account number: ");
        setNumber();
        System.out.println();
        System.out.print("Enter account holder: ");
        setHolder();
        System.out.println();
        System.out.print("Is there an initial deposit? (y/n): ");
        answer = sc.next();

        switch (answer) {
            case "y" -> {
                System.out.println();
                System.out.print("Enter initial deposit value: ");
                double value = sc.nextDouble();
                Account checkingAccount1 = new Account(number, holder, value);
                System.out.println(checkingAccount1);
            }
            case "n" -> {
                Account checkingAccount2 = new Account(number, holder);
                System.out.println(checkingAccount2);
            }
            default ->
                    throw new IllegalStateException("Unexpected value: " + answer + ", try again with (y) for yes and (n) for no.");
        }

        return "End of transaction";
    }
}
