package com.emeritus.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emeritus.org.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
