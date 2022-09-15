package com.example.Portal.Talent2.modal;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long education_id;
    private String collage_name;
    private String level;
    private String study;
    private LocalDate education_year_start;
    private LocalDate education_year_end;
    @ManyToOne
    private PersonalDetail personalDetail;
}
