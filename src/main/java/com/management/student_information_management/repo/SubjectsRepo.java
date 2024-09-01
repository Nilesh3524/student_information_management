package com.management.student_information_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.management.student_information_management.model.Subjects;

import java.util.List;
import java.util.Optional;


public interface SubjectsRepo extends JpaRepository<Subjects,Integer>{
    
    @Query("from Subjects s where s.student.rollNo = :rollNo")
    Optional<List<Subjects>> findByStudentRollNo(@Param("rollNo") String rollNo);

}
