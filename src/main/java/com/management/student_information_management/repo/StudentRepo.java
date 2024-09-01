package com.management.student_information_management.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.student_information_management.model.Student;

public interface StudentRepo extends JpaRepository<Student,String>{
    
    Optional<Student> findByRollNo(String rollNo);

    Optional<Student> findByRollNoAndEmail(String rollNo, String email);

    Optional<Student> findByEmail(String email);

    boolean existsByEmail(String email);

}
