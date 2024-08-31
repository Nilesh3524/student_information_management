package com.management.student_information_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String index(){

        return "index";
    }


    @GetMapping("/student-login")
    public String studentLogin(Model m){

        m.addAttribute("title", "Student login");

        return "/student/login";
    }

    

}
