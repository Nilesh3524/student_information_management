package com.management.student_information_management.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.student_information_management.model.Student;

public interface StudentRepo extends JpaRepository<Student,String>{
    
}
