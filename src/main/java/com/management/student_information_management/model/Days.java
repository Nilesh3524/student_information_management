package com.management.student_information_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
public class Days {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int pday1;
    private int pday2;
    private int pday3;
    private int pday4;
    private int pday5;
    private int pday6;
    private int pday7;
    private int pday8;

    private int tday;


    @ManyToOne
    private Student student;
}
