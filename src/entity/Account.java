package entity;

import app.Program;

import java.util.Scanner;

public class Account {
    Scanner sc = new Scanner(System.in);
    private String accountHolderName;
    private int accountNumber;
    private double accountBalance;
    public double withdrawTax = 5;

    public Account() {

    }
    public Account(int accountNumber, String accountHolderName, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountBalance = accountBalance;
    }

    public Account(int accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
    }

    public void setAccountHolderName() {
        this.accountHolderName = sc.nextLine();
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    private void setAccountNumber() {
        double doubleRandomNumber = Math.random() * 9999;

        this.accountNumber = (int)doubleRandomNumber;
    }
    public int getAccountNumber() {
        return accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void accountDeposit(double value) {
        accountBalance += value;

        accountData();
    }

    public void accountWithdraw(double value) {
        accountBalance = accountBalance - (value + 5);

        accountData();
    }

    public String accountData() {
        return "Account data: \nAccount: "
                + getAccountNumber()
                + ", Holder: "
                + getAccountHolderName()
                + ", Balance: $ "
                + String.format("%.2f", getAccountBalance())
                ;
    }

    public String toString() {
        System.out.print("Your account number: ");
        setAccountNumber();
        System.out.println(accountNumber);
        System.out.println();
        System.out.print("Enter account holder: ");
        setAccountHolderName();
        System.out.println();
        System.out.print("Is there an initial deposit? (y/n): ");
        String answer = sc.next();


        switch(answer) {
            case "y" -> {
                System.out.println();
                System.out.print("Enter initial deposit value: ");
                accountBalance = sc.nextDouble();
                Account checkingAccount1 = new Account(getAccountNumber(), getAccountHolderName(), getAccountBalance());
                System.out.println(checkingAccount1.accountData());
            }
            case "n" -> {
                Account checkingAccount2 = new Account(getAccountNumber(), getAccountHolderName());
                System.out.println(checkingAccount2.accountData());
            }
            default ->
                    throw new RuntimeException("Unexpected value: " + answer + ", try again with (y) for yes and (n) for no.");
        }

        return "End of transaction.";
    }
}

