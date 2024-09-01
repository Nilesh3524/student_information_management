package com.management.student_information_management.controller;


import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.management.student_information_management.helper.Message;
import com.management.student_information_management.model.SGPA;
import com.management.student_information_management.model.Student;
import com.management.student_information_management.service.SGPAService;
import com.management.student_information_management.service.StudentService;
import com.management.student_information_management.service.SubjectsService;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private SGPAService sgpaService;

    @Autowired
    private SubjectsService subjectsService;


    private Logger logger = LoggerFactory.getLogger(AdminController.class);
    
    //home page
    @GetMapping("/dashboard")
    public String dashboard(Model m){

        m.addAttribute("title", "DASHBOARD");


        return "admin/home";
    }

    //admin login page
    @GetMapping("/login")
    public String login(Model m) {

        m.addAttribute("tittle", "Admin Login");
        return "admin/login";
    }

    //process login
    @PostMapping("/process-login")
    public String processLogin(HttpSession session, BindingResult res) {

        // Message message = Message.builder().content("Login
        // Success").type("alert-success").build();

        session.setAttribute("message", new Message("message", "alert-success"));

        return "redirect:/admin/home";
    }

    //add student page
    @GetMapping("/add-student")
    public String addStudentForm(Model m){

        m.addAttribute("title", "Add Student");

        return "admin/addStudent";
    }

    //process add student
    @PostMapping("/process-add-student")
    public String addStudent(@ModelAttribute("student") Student student){

        System.out.println(student);

        if (this.studentService.isStudentExits(student.getRollNo()) || this.studentService.isStudentExitsByEmail(student.getEmail())) {
            return "admin/addStudent";
        }

        this.studentService.addStudent(student);

        return "redirect:dashboard";
        
    }

    //search for sgpa page
    @GetMapping("/search-sgpa")
    public String searchForSGPA(){

        return "admin/search";
    }

    //add sgpa page
    @GetMapping("/add-sgpa")
    public String addSGPAForm(@RequestParam("rollNo") String rollNo, Model m){

        System.out.println(rollNo);

        m.addAttribute("rollNo", rollNo);

        if (this.studentService.isStudentExits(rollNo)) {
            
            return "admin/addSGPA";

        }else{
            return "admin/search";
        }

    }

    //process add sgpa
    @PostMapping("/process-add-sgpa")
    public String addSgpa(@ModelAttribute("sgpa") SGPA sgpa,@RequestParam("rollNo") String rollNo){

        System.out.println(sgpa);

        System.out.println(rollNo);

        if (this.studentService.isStudentExits(rollNo)) {
            
            Student student = this.studentService.getStudentByRollNo(rollNo).get();

            sgpa.setStudent(student);

            student.getSgpa().add(sgpa);

            double avgSgpa = (sgpa.getSgpa1() + sgpa.getSgpa2() + sgpa.getSgpa3() + sgpa.getSgpa4() + sgpa.getSgpa5() + sgpa.getSgpa6() + sgpa.getSgpa7() + sgpa.getSgpa8())/8;

            student.setAvgSGPA(avgSgpa);

            // SGPA savedSGPA = this.sgpaService.addSGPA(sgpa);

            this.studentService.addStudent(student);

            // logger.info(savedSGPA.toString());

            // logger.info(updatedStudent.toString());

            return "redirect:dashboard";

        }else{
            return "admin/search";
        }

    }

    //search attendence page
    @GetMapping("/search-attendence")
    public String searchForAttendence(){

        return "admin/search_attendence";
    }

    //add attendence page
    @GetMapping("/add-attendence")
    public String addAttendenceForm(@RequestParam("rollNo") String rollNo, Model m){

        System.out.println(rollNo);

        m.addAttribute("rollNo", rollNo);

        return "admin/addAttendence";
    }


}
