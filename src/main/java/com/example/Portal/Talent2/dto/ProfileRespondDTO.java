package com.example.Portal.Talent2.dto;

import java.time.LocalDate;

import lombok.Data;
@Data
public class ProfileRespondDTO {
    // prsonal info
    private String firs_name;
    private String second_name;
    private String last_name;
    private String Location;
    private String city;
    private String gender;
    private String phone;
    private String biography;

    // education info
    private String collage_name;
    private LocalDate education_year_start;
    private LocalDate education_year_end;
    private String level;
    private String study;

    // skill info
    private String skill_name;

    //experience 
    private String company_name;
    private String locations;
    private LocalDate startyear;
    private LocalDate endyear;

    // user
    private String user_name;
    private String email;


}
