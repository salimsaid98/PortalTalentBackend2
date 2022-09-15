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
@Table(name = "Experience")
public class Experiance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long experience_id;
    private String company_name;
    private String locations;
    private LocalDate startyear;
    private LocalDate endyear;
    @ManyToOne
    private PersonalDetail personalDetail;
}
