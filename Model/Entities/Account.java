package Model.Entities;

import Model.Exceptions.CashierException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Double currentBalance() {
        return balance;
    }

    public void withdraw(double amount){
        validateWithdraw(amount);
        balance -= amount;
    }

    public void validateWithdraw(double amount){
        if(amount > balance){
            throw new CashierException("Not enough balance");
        }
        if (amount > withdrawLimit){
            throw new CashierException("The amount exceeds withdraw limit");
        }
    }
}
