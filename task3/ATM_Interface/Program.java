package com.task3.ATM_Interface;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter account number: ");
        String accountNumber = sc.nextLine();

        System.out.print("Enter account holder name: ");
        String accountHolder = sc.nextLine();

        BankAccount bankAccount = new BankAccount(0.0, accountNumber, accountHolder);
        ATM atm = new ATM(bankAccount);
        atm.showMenu();
	}

}
