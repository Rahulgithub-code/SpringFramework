package com.spring.JDBC.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.JDBC.entities.Student;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;

	public int insert(Student student) {
		// query
		String query = "insert into student(id,name,city) value(?,?,?)";
		int result = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return result;
	}

	public int change(Student student) {
		// updating
		String query = "update student set name=?, city=? where id=? ";
		int result = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return result;
	}

	public int delete(int studentId) {
		// delete
		String query = "delete from student where id=?";
		int result = this.jdbcTemplate.update(query, studentId);
		return result;
	}

	public Student getStudent(int studentId) {
		// selecting single student data
		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new rowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
		return student;
	}

	public List<Student> getAllStudents() {
		// Selecting multiple student
		String query ="select * from student";
		List<Student> students = this.jdbcTemplate.query(query, new rowMapperImpl());
		return students;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
