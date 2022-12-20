package com.emeritus.org.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emeritus.org.entity.Student;
import com.emeritus.org.repository.StudentRepository;
import com.emeritus.org.service.StudentService;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Service
public class StudentServiceImpl implements StudentService{

	private StudentRepository studentRepository;
	@Autowired
	private EntityManager entityManager;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(String id)  {
		String queryStr = "SELECT "+id +", email, first_name as firstName, last_name as lastName FROM students WHERE id = " + id;
		Query query = entityManager.createNativeQuery(queryStr);
		List results = query.getResultList();
		if(results.isEmpty()){
			System.out.println(results);
		}
		Object result = results.get(0);

		Student student = new Student();
		student.setId((Long) ((Object[]) result)[0]);
		student.setEmail(((Object[]) result)[1].toString());
		student.setFirstName(((Object[]) result)[2].toString());
		student.setLastName(((Object[]) result)[3].toString());
		return student;

	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);	
	}

}
