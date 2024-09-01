package com.management.student_information_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.management.student_information_management.model.SGPA;
import java.util.Optional;


public interface SGPARepo extends JpaRepository<SGPA,Integer>{
    
    @Query("from SGPA s where s.student.rollNo = :rollNo")
    Optional<SGPA> findByStudentRollNo(@Param("rollNo") String rollNo);

}
