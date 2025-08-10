package com.task3.ATM_Interface;

import java.util.Scanner;

public class ATM {
	private BankAccount account;
	
	public ATM(BankAccount account) {
		this.account = account;
	}
	
	public void showMenu() {
	
		Scanner sc = new Scanner(System.in);
		int choice = -1;
		
		while(choice != 4) {
			System.out.println("=======MENU=======");
			System.out.println("1.Deposit");
			System.out.println("2.Withdraw");
			System.out.println("3.Check Balance");
			System.out.println("4.Exit");
			System.out.print("Enter the choice : ");
			choice = sc.nextInt();
			System.out.println("=====================");
			
			switch(choice) {
			case 1:
				System.out.print("Enter amount to deposit: ");
                double depositAmount = sc.nextDouble();
				account.deposit(depositAmount);
				break;
				
			case 2:
				System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = sc.nextDouble();
				account.withdraw(withdrawAmount);
				break;
				
			case 3:
				System.out.println("Current balance : "+account.getBalance());
				break;
				
			case 4:
				System.out.println("Thank you for using the ATM. Goodbye!");
				break;
				
			default:
				System.out.println("Invalid choice...Please try again..!");
			}
		}
	}
	
	
}
