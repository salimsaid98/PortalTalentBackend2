package com.example.Portal.Talent2.modal;


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
public class Profle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prifile_id;
    @ManyToOne
    private PersonalDetail personalDetail;
    @ManyToOne
    private Skill skill;
    @ManyToOne
    private Education education;
    @ManyToOne
    private Experiance experiance;
    @ManyToOne
    private User user;


}
