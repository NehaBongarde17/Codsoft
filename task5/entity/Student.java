package com.task5.entity;

import java.util.Scanner;

public class Student {
	private String name;
	private int roll_no;
	private String grade;
	private int age;
	private String email;
	
	public Student() {
		
	}

	public Student(String name, int roll_no, String grade, int age, String email) {
		super();
		this.name = name;
		this.roll_no = roll_no;
		this.grade = grade;
		this.age = age;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRoll_no() {
		return roll_no;
	}

	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "[name=" + name + ", roll_no=" + roll_no + ", grade=" + grade + ", age=" + age + ", email="
				+ email + "]";
	}
	
	public void accept(Scanner sc) {
	    System.out.print
	    ("Enter name: ");
	    name = sc.nextLine();
	    
	    while (name.trim().isEmpty()) {
	        System.out.print("Name cannot be empty. Re-enter name: ");
	        name = sc.nextLine();
	    }

	    System.out.print("Enter roll number: ");
	    while (true) {
	        try {
	            roll_no = Integer.parseInt(sc.nextLine());
	            if (roll_no <= 0) {
	                System.out.print("Roll number must be positive. Re-enter: ");
	                continue;
	            }
	            break;
	        } catch (NumberFormatException e) {
	            System.out.print("Invalid roll number. Enter an integer: ");
	        }
	    }

	    System.out.print("Enter grade: ");
	    grade = sc.nextLine();
	    while (grade.trim().isEmpty()) {
	        System.out.print("Grade cannot be empty. Re-enter grade: ");
	        grade = sc.nextLine();
	    }

	    System.out.print("Enter age: ");
	    while (true) {
	        try {
	            age = Integer.parseInt(sc.nextLine());
	            if (age <= 0) {
	                System.out.print("Age must be positive. Re-enter: ");
	                continue;
	            }
	            break;
	        } catch (NumberFormatException e) {
	            System.out.print("Invalid age. Enter an integer: ");
	        }
	    }

	    System.out.print("Enter email: ");
	    email = sc.nextLine();
	    while (!email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$")) {
	        System.out.print("Invalid email format. Re-enter email: ");
	        email = sc.nextLine();
	    }
	}

}
	
	
