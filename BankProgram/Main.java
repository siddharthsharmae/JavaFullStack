package com.Siddharth.Upload.JavaFullStack.BankProgram;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
    static double currentbalance = 2000;


    static void checkBalance(ResourceBundle rb, NumberFormat nf) {
        System.out.println("\n" + rb.getString("currentBalance"));
        System.out.println(nf.format(currentbalance));
    }

    static void depositMoney(double amount, ResourceBundle rb) {
        currentbalance += amount;
        System.out.println("\n" + rb.getString("depositSuccess"));
    }

    static void withdrawMoney(double amount, ResourceBundle rb) {
        if (amount > currentbalance) {
            System.out.println("\n" +rb.getString("insufficientFunds"));
            return;
        }
        currentbalance -= amount;
        System.out.println(rb.getString("withdrawSuccess"));
    }

    public static void main(String[] args) {
        Locale language;
        ResourceBundle rb;
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("Enter your language preference : \nअपनी भाषा प्राथमिकता दर्ज करें : \n 1 for English \n 2 for Hindi ");
        choice = sc.nextInt();
        if (choice == 1) {
            language = Locale.of("en", "US");
        } else if (choice == 2) {
            language = Locale.of("hi", "IN");
        } else {
            System.out.println("Invalid Choice!");
            System.out.println("Default language English is selected");
            language = Locale.of("en", "US");
        }
        rb = ResourceBundle.getBundle("com.Siddharth.BankProgram.ResourceBundle", language);
        System.out.println("\n----------------------------\n");
        sc.nextLine();
        System.out.println(rb.getString("enterName"));
        NumberFormat nf = NumberFormat.getCurrencyInstance(language);
        String name = sc.nextLine();
        int num;
        do {
            // System.out.println("(1) for checking Balance \n(2) for Depositing Money \n(3) for Withdrawing Money \n(0) for Exit");
            System.out.println("\n----------------------------\n");
            System.out.println(rb.getString("menuCheckBalance"));
            System.out.println(rb.getString("menuDepositMoney"));
            System.out.println(rb.getString("menuWithdrawMoney"));
            System.out.println(rb.getString("menuExit"));
            num = sc.nextInt();
            switch (num) {
                case 1 -> checkBalance(rb, nf);
                case 2 -> {
                    System.out.print(rb.getString("promptDepositAmount"));
                    double deposit = sc.nextDouble();
                    if (deposit <= 0) {
                        System.out.println(rb.getString("invalidAmount"));
                    } else {
                        depositMoney(deposit, rb);
                    }
                }
                case 3 -> {
                    System.out.print(rb.getString("promptWithdrawAmount"));
                    double withdraw = sc.nextDouble();
                    if (withdraw <= 0) {
                        System.out.println(rb.getString("invalidAmount"));
                    }
                    withdrawMoney(withdraw, rb);
                }
                case 0 -> System.out.println(rb.getString("exitMessage"));
                default -> System.out.println(rb.getString("invalidChoice"));
            }
        } while (num != 0);
    }
}
