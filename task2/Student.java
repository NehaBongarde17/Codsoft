package com.task2;

import java.util.Scanner;

public class Student {

	public static void main(String[] args) {
		int student_no;
		int subject_no;
		int marks;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of student : ");
		student_no = sc.nextInt();
		
		for(int i = 0;i < student_no; i++) {
			System.out.print("Enter the number of subject : ");
			subject_no = sc.nextInt();
			int total = 0;
			for(int j = 1;j <= subject_no; j++) {
				System.out.printf("Enter the marks of %d subject : ",j);
				marks = sc.nextInt();
				if(marks >=0 && marks<=100) {
					total +=marks;
				}
				else {
					System.out.println("Invalid input! Marks should be between 0 and 100. Please try again.");
					j--;
				}
			}
			System.out.println("Sum of marks : "+total);
			double avg = total/subject_no;
			System.out.println("Average Percentage : "+avg);
			
			if(avg>90 && avg<=100) {
				System.out.println("Grade : A+");
			}
			else if(avg>80 && avg<=90) {
				System.out.println("Grade : A");
			}
			else if(avg>70 && avg<=80) {
				System.out.println("Grade : B");
			}
			else if(avg>60 && avg<=70) {
				System.out.println("Grade : C");
			}
			else if(avg>50 && avg<=60) {
				System.out.println("Grade : D");
			}
			else if(avg>35 && avg<=50) {
				System.out.println("Grade : E");
			}
			else {
				System.out.println("Grade : F");
				System.out.println("Keep trying, you can do better next time!");	
			}
		System.out.println();
		}
		
	}

}
