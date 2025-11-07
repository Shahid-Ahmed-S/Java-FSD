package com.Day05.Exception;

public class CustomExceptionDemo {

    static class InsufficientFundsException extends Exception {
        public InsufficientFundsException(String message) {
            super(message);
        }
    }

    static class BankAccount {
        int balance;

        public BankAccount(int initialBalance) {
            this.balance = initialBalance;
        }

        public void deposit(int amount) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }

        public void withdraw(int amount) throws InsufficientFundsException {
            if (balance < amount) {
                throw new InsufficientFundsException("Insufficient Balance");
            }
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }

        public void getBalance() {
            System.out.println("Current Balance: " + balance);
        }
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount(5000);
        acc.deposit(8000);
        acc.getBalance();

        try {
            acc.withdraw(15000);
        } catch (InsufficientFundsException e) {
            System.out.println("InsufficientFundsException: " + e.getMessage());
        }

        acc.getBalance();
    }
}
