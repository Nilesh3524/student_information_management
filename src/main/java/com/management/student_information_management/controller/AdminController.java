package com.management.student_information_management.controller;


import java.util.stream.Stream;

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

    @GetMapping("/search-sgpa")
    public String searchForSGPA(){

        return "admin/search";
    }

    @GetMapping("/add-sgpa")
    public String addSGPAForm(@RequestParam("rollNo") String rollNo, Model m){

        System.out.println(rollNo);

        m.addAttribute("rollNo", rollNo);

        return "admin/addSGPA";
    }

    @PostMapping("/process-add-sgpa")
    public String addSgpa(@ModelAttribute("sgpa") SGPA sgpa,@RequestParam("rollNo") String rollNo){

        System.out.println(sgpa);

        System.out.println(rollNo);

        return "redirect:dashboard";
    }

    @GetMapping("/search-attendence")
    public String searchForAttendence(){

        return "admin/search_attendence";
    }

    @GetMapping("/add-sgpa")
    public String addAttendenceForm(@RequestParam("rollNo") String rollNo, Model m){

        System.out.println(rollNo);

        m.addAttribute("rollNo", rollNo);

        return "admin/addAttendence";
    }


}
