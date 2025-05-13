package Application;

import Model.Entities.Account;
import Model.Exceptions.CashierException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String [] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account data");
        System.out.print("Number: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Holder: ");
        String holder = sc.nextLine();
        System.out.print("Initial balance: ");
        double balance = sc.nextDouble();
        System.out.print("Withdraw limit: ");
        double withdrawLimit = sc.nextDouble();

        Account acc = new Account(number, holder, balance, withdrawLimit);

        try{
            System.out.print("Enter amount for withdraw: ");
            double amount = sc.nextDouble();
            acc.withdraw(amount);
        }
        catch (CashierException c){
            System.out.println("Withdraw error: " + c.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Unexpected ERROR!");
        }

        System.out.println("Current balance: " + acc.currentBalance());

        sc.close();
    }
}
