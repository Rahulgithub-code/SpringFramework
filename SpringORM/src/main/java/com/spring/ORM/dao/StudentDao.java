package com.spring.ORM.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.ORM.entities.Student;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;

	// for writable transaction
	@Transactional
	public int insert(Student student) {
		// insert
		Integer r = (Integer) this.hibernateTemplate.save(student);
		return r;
	}

	// get the single student
	public Student getStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}

	// get multiple data
	public List<Student> getAllStudents() {
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
	}

	// delete student
	@Transactional
	public void deleteStudentById(int studentId) {
		// get student first then delete
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);
	}

	// update student
	@Transactional
	public void updateStudent(int id, Student newStudent) {
		// get student first then updated
		Student student = this.hibernateTemplate.get(Student.class, id);
		student.setStudentname(newStudent.getStudentname());
		student.setStudentCity(newStudent.getStudentCity());
		
		this.hibernateTemplate.update(student);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
