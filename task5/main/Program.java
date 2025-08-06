package com.task5.main;

import java.util.Scanner;

import com.task3.entity.Student;
import com.task3.entity.StudentManagementSystem;

public class Program {
	
	public static int menuList(Scanner sc) {
		System.out.println("================STUDENT DETAILS===============");
		System.out.println("1. Add Student");
		System.out.println("2. Edit Student");
		System.out.println("3. Remove Student");
		System.out.println("4. Search Student");
		System.out.println("5. Display All Student");
		System.out.println("6. Exit");
		System.out.print("Enter your choice : ");
		int choice = sc.nextInt();
		System.out.println("===========================================");
		return choice;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Student student = new Student();
		
		StudentManagementSystem sms = new StudentManagementSystem();
		int choice;
		while((choice = menuList(sc))!=0) {
			switch(choice) {
			case 1:
				sms.addStudent(sc);
				break;
				
			case 2:
				if(student != null) {
					sms.editStudent(sc);
				}
				else {
					System.out.println("There is no any student.");
				}
				break;
				
			case 3:
				if(student != null) {
					sms.removeStudent(student.getRoll_no(), sc);
				}
				else {
					System.out.println("There is no any student.");
				}
				break;
				
			case 4:
				if(student != null) {
					sms.searchStudent(student.getRoll_no(), sc);
				}
				else {
					System.out.println("There is no any student.");
				}
				break;
				
			case 5:
				sms.displayAllStudent();
				break;
				
			case 6 :
				System.out.println("Exit.....!");
				break;
				
			default:
				System.out.println("Invalid choice . Please try again...!");
				break;
			}
		}
	}

}
