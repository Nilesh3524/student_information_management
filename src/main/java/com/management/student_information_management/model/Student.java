package com.management.student_information_management.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Student {
    
    @Id
    @Column(unique = true)
    private String rollNo;

    private String name;

    private String branch;

    private String address;

    @Column(unique = true)
    private String email;

    private String phone;

    private boolean forum;

    private boolean backlog;

    private String cetification;

    private String participation;

    private double avgSGPA;

    private double avgAttendence;

    // subjects
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "student")
    private List<Subjects> subjects=new ArrayList<>();


    //sgpa
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "student")
    private List<SGPA> sgpa=new ArrayList<>();

}
