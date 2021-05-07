package com.spring.JDBC;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.JDBC.dao.StudentDao;
import com.spring.JDBC.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Strated . . .");

		// Spring jdbc -> JdbcTemplate
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/JDBC/config.xml");

		// insert
		// studentDao is a parent of StudentDaoImpl class
		// StudentDaoImpl s1= context.getBean("studentDao",StudentDaoImpl.class);
		StudentDao s1= context.getBean("studentDao",StudentDao.class);
		Student student1 = new Student();
		student1.setId(105);
		student1.setName("Sona");
		student1.setCity("JSR");
		int result= s1.insert(student1);
		System.out.println("Student added " + result);

		// update
//		StudentDao s2= context.getBean("studentDao",StudentDao.class);
//		Student student1 = new Student();
//		student1.setId(103);
//		student1.setName("Rahul kumar ram");
//		student1.setCity("RNC");
//		int result1=s2.change(student1);
//		System.out.println("Student updated " + result1);

		// delete
//		StudentDao s3 = context.getBean("studentDao", StudentDao.class);
//		int result2 = s3.delete(103);
//		System.out.println("Student delete " + result2);

		// select single data
//		StudentDao s3 = context.getBean("studentDao", StudentDao.class);
//		Student student = s3.getStudent(101);
//		System.out.println(student);
		
		// selecting all student
		StudentDao s3 = context.getBean("studentDao", StudentDao.class);
		List<Student> students = s3.getAllStudents();
		for (Student student : students) {
			System.out.println(student);
		}
	}
}