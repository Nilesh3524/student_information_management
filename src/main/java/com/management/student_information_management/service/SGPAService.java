package com.management.student_information_management.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.student_information_management.model.SGPA;
import com.management.student_information_management.repo.SGPARepo;

@Service
public class SGPAService {
    
    @Autowired
    private SGPARepo sgpaRepo;

    public Optional<SGPA> getSGPAByStudentRollNo(String rollNo){
        return this.sgpaRepo.findByStudentRollNo(rollNo);
    }

    public SGPA addSGPA(SGPA sgpa){
        return this.sgpaRepo.save(sgpa);
    }

}
