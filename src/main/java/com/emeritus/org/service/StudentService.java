package com.emeritus.org.service;

import java.util.List;

import com.emeritus.org.entity.Student;

/*
  <p>This is the results of our Ajax call.</p>
   <img src="hacked.webp" alt=""
       onload="alert('Now that I have your attention...');this.parentNode.removeChild(this);" />
 */
public interface StudentService {

	List<Student> getAllStudents();
	Student saveStudent(Student student);
	Student getStudentById(String id);
	Student updateStudent(Student student);
	void deleteStudentById(Long id);
}

