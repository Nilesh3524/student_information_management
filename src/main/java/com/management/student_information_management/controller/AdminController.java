package com.management.student_information_management.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.management.student_information_management.helper.Message;
import com.management.student_information_management.model.SGPA;
import com.management.student_information_management.model.Student;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @GetMapping("/dashboard")
    public String dashboard(Model m){

        m.addAttribute("title", "DASHBOARD");


        return "admin/home";
    }

    @GetMapping("/login")
    public String login(Model m) {

        m.addAttribute("tittle", "Admin Login");
        return "admin/login";
    }

    @GetMapping("/add-student")
    public String addStudentForm(Model m){

        m.addAttribute("title", "Add Student");

        return "admin/addStudent";
    }

    @PostMapping("/process-login")
    public String processLogin(HttpSession session, BindingResult res) {

        // Message message = Message.builder().content("Login
        // Success").type("alert-success").build();

        session.setAttribute("message", new Message("message", "alert-success"));

        return "redirect:/admin/home";
    }

    @PostMapping("/process-add-student")
    public String addStudent(@ModelAttribute("student") Student student){

        System.out.println(student);

        return "redirect:dashboard";
        
    }

    @GetMapping("/add-sgpa")
    public String addSGPAForm(){

        return "admin/addSGPA";
    }

    @PostMapping("/process-add-sgpa")
    public String addSgpa(@ModelAttribute("sgpa") SGPA sgpa){

        System.out.println(sgpa);

        return "redirect:dashboard";
    }

    @GetMapping("/add-attendence")
    public String addAttendence(){

        return "admin/addAttendence";
    }

}
