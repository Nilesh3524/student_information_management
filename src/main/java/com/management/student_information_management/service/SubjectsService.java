package com.management.student_information_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.student_information_management.model.Subjects;
import com.management.student_information_management.repo.SubjectsRepo;

@Service
public class SubjectsService {
    
    @Autowired
    private SubjectsRepo subjectsRepo;

    public Optional<List<Subjects>> getSubjectsByStudentRollNo(String rollNo){
        return this.subjectsRepo.findByStudentRollNo(rollNo);
    }

}
