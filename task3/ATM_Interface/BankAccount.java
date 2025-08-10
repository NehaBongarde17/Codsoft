package com.task3.ATM_Interface;

public class BankAccount {
	private double balance;
	private String accountNumber;
	private String accountHolder;
	
	public BankAccount() {
		
	}
	
	public BankAccount(double balance,String accountNumber,String accountHolder) {
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void deposit(double amount) {
		if(amount>0) {
			balance += amount;
			System.out.println("Amount deposited successfully");
		}
		else {
			System.out.println("Invalid amount");
		}
		
	}
	
	public void withdraw(double amount) {
		if(amount <= balance) {
			balance -= amount;
			System.out.println("Amount withdraw successfully");
		}
		else {
			System.out.println("Insufficient balance.");
		}
	}
	
}
