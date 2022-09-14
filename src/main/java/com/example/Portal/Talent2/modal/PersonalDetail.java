package com.example.Portal.Talent2.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class PersonalDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personal_id;
    private String firs_name;
    private String second_name;
    private String last_name;
    private String Location;
    private String city;
    private String gender;
    private String phone;
    private String biography;
}
