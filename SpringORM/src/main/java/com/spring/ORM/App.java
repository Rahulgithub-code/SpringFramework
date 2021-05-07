package com.spring.ORM;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.ORM.dao.StudentDao;
import com.spring.ORM.entities.Student;
import com.sun.java.swing.action.NewAction;

import net.bytebuddy.asm.Advice.This;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao dao = context.getBean("studentDao", StudentDao.class);
		boolean flag = true;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		while (flag) {
			System.out.println("Press 1 : Add new Student");
			System.out.println("Press 2 : Show all Student ");
			System.out.println("Press 3 : Show Student By Id");
			System.out.println("Press 4 : Delect Student by Id");
			System.out.println("Press 5 : Update Stundent by Id");
			System.out.println("Press 6 : Exit");
			
			try {
				System.out.print("Enter your choice : ");		
				int input  = Integer.parseInt(br.readLine());
				System.out.println();
				
				
				switch (input) {
				case 1:
					//add student
					System.out.print("Enter student id :");
					int s_id  = Integer.parseInt(br.readLine());
					System.out.print("Enter student name :");
					String s_name  = br.readLine();
					System.out.print("Enter student city :");
					String s_city  = br.readLine();
					
					//creating student object
					Student student = new Student(s_id,s_name,s_city);
					int result =  dao.insert(student);
					System.out.println("Id : " +result+" added");
					System.out.println("****************************");
					System.out.println();
					break;

				case 2:
					//show all student
					System.out.println("****************************");
					List<Student> students = dao.getAllStudents();
					
					for (Student st : students) {
						System.out.println();
						System.out.print("Id : " + st.getStudentId());
						System.out.print(", Name : " + st.getStudentname());
						System.out.println(", City : " + st.getStudentCity());
					}
					System.out.println();
					System.out.println("****************************");
					break;
				case 3:
					//show single student
					System.out.print("Enter stduent Id: ");
					int id  = Integer.parseInt(br.readLine());
					Student s =  dao.getStudent(id);
					System.out.println();
					System.out.print("Id : " + s.getStudentId());
					System.out.print(", Name : " + s.getStudentname());
					System.out.println(", City : " + s.getStudentCity());
					System.out.println();
					System.out.println("****************************");
					break;
				case 4:
					//delete student by id
					System.out.print("Enter stduent Id: ");
					int delete_id  = Integer.parseInt(br.readLine());
					dao.deleteStudentById(delete_id);
					System.out.println();
					System.out.println("Id : "+delete_id+ " Stduent is deleted.");
					System.out.println();
					System.out.println("****************************");
					break;
				case 5:
					//update student by Id
					System.out.print("Enter stduent Id: ");
					int update_id  = Integer.parseInt(br.readLine());
					System.out.print("Enter student name :");
					String st_name  = br.readLine();
					System.out.print("Enter student city :");
					String st_city  = br.readLine();
					
					Student studentOb = new Student();
					studentOb.setStudentname(st_name);
					studentOb.setStudentCity(st_city);
					
					dao.updateStudent(update_id, studentOb);
					System.out.println();
					System.out.println("Updated");
					
					break;
				case 6:
					//Exit
					flag = false;
					break;
				}
			} catch (Exception e) {
				System.out.println("Invalid Choice.");
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Thanks for using our application.");
		System.out.println("See you soon.");

	}
}
