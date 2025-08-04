package com.task5.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.task3.Util.DbUtil;

public class StudentManagementSystem {
	
	//public static final Scanner sc = new Scanner(System.in); 
	//StudentManagementSystem sms = new StudentManagementSystem();
	
	public static void addStudent(Scanner sc) {
		Student student  = new Student();
		sc.nextLine();
		student.accept(sc);
		String sql = "INSERT INTO Student(name,grade,age,email) VALUES(?,?,?,?)";
		try(Connection connection = DbUtil.getConnection()){
			try(PreparedStatement insertstatment = connection.prepareStatement(sql)){
				insertstatment.setString(1,student.getName());
				insertstatment.setString(2, student.getGrade());
				insertstatment.setInt(3, student.getAge());
				insertstatment.setString(4, student.getEmail());
				insertstatment.executeUpdate();
				System.out.println("Student added successfully....");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void removeStudent(int roll_no,Scanner sc) {
		String sql = "DELETE FROM Student WHERE roll_no = ?";
		System.out.print("Enter the roll number of student to delete : ");
		roll_no = sc.nextInt();
		try(Connection connection = DbUtil.getConnection()){
			try(PreparedStatement deletestatment = connection.prepareStatement(sql)){
				deletestatment.setInt(1,roll_no);
				deletestatment.executeUpdate();
				System.out.println("Student is deleted...:(");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void searchStudent(int roll_no,Scanner sc) {
		String sql = "SELECT * FROM Student WHERE roll_no = ?";
		System.out.print("Enter the roll number of student to search : ");
		roll_no = sc.nextInt();
		try(Connection connection = DbUtil.getConnection()){
			try(PreparedStatement selectstatment = connection.prepareStatement(sql)){
				selectstatment.setInt(1,roll_no);
				ResultSet rs = selectstatment.executeQuery();
				while(rs.next()) {
					System.out.print(rs.getString(2)+" - ");
					System.out.print(rs.getInt(3)+" - ");
					System.out.print(rs.getString(4)+" - ");
					System.out.println(rs.getString(5));	
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void displayAllStudent() {
		String sql = "SELECT * FROM Student";
		try(Connection connection = DbUtil.getConnection()){
			try(PreparedStatement selectstatement = connection.prepareStatement(sql)){
				ResultSet rs = selectstatement.executeQuery();
				List<Student> studentList = new ArrayList<Student>();
				while(rs.next()) {
					Student student = new Student();
					student.setRoll_no(rs.getInt(1));
					student.setName(rs.getString(2));
					student.setAge(rs.getInt(3));
					student.setGrade(rs.getString(4));
					student.setEmail(rs.getString(5));
					studentList.add(student);
				}
				studentList.forEach(s -> System.out.println(s));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void editStudent(Scanner sc) {
		displayAllStudent();
		String sql = "UPDATE Student SET name = ? WHERE roll_no = ?";
		System.out.print("Enter the roll number of student to update the name : ");
		int roll_no = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter the name want to update : ");
		String name = sc.nextLine();
		try(Connection connection = DbUtil.getConnection()){
			try(PreparedStatement updateStatement = connection.prepareStatement(sql)){
				updateStatement.setInt(2,roll_no);
				updateStatement.setString(1, name);	
				int rowsAffected = updateStatement.executeUpdate();
		        if (rowsAffected > 0) {
		            System.out.println("Student edited successfully...");
		        } else {
		            System.out.println("No student found with the given roll number.");
		        }
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	
	public void saveStudentToDB(Student student) {
	    String sql = "INSERT INTO students (roll_number, name, grade, age) VALUES (?, ?, ?, ?)";
	    try (Connection conn = DbUtil.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setInt(1, student.getRoll_no());
	        stmt.setString(2, student.getName());
	        stmt.setString(3, student.getGrade());
	        stmt.setInt(4, student.getAge());
	        stmt.executeUpdate();
	        System.out.println("Saved to DB.");
	    } catch (SQLException e) {
	        System.out.println("DB Error: " + e.getMessage());
	    }
	}
}
