package com.example.Portal.Talent2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Portal.Talent2.exception.Datanotfound;
import com.example.Portal.Talent2.modal.Education;
import com.example.Portal.Talent2.modal.Experiance;
import com.example.Portal.Talent2.modal.PersonalDetail;
import com.example.Portal.Talent2.modal.Skill;
import com.example.Portal.Talent2.repository.EducationRepo;
import com.example.Portal.Talent2.repository.ExperianceRepo;
import com.example.Portal.Talent2.repository.PersonalDetailRepo;
import com.example.Portal.Talent2.repository.SkillRepo;

import lombok.Data;
@Data
@Service
public class PersonalDetailService {
    @Autowired
    private PersonalDetailRepo personalDetailRepo;

    @Autowired
    private EducationRepo educationRepo;

    @Autowired
    private ExperianceRepo experianceRepo;

    @Autowired SkillRepo skillRepo;

    public PersonalDetail save(PersonalDetail personalDetail){
        // User user = new User();
        // user.setUser_id(personalDetail.getUser().getUser_id());
        PersonalDetail personalDetail2 = personalDetailRepo.save(personalDetail);
        return personalDetail2;
    }

    public List<PersonalDetail> getall(){
        List<PersonalDetail>list = new ArrayList<>();
        for(PersonalDetail personalDetail:personalDetailRepo.findAll()){
            list.add(personalDetail);       
        }
        return list;
    }

    public PersonalDetail getbyid(Long id){
     PersonalDetail PersonalDetail = personalDetailRepo.findById(id).orElseThrow(()->new Datanotfound("invalid id"));
     return PersonalDetail;
    }

    public PersonalDetail delete(Long id){
        PersonalDetail personalDetail = getbyid(id);
       personalDetailRepo.delete(personalDetail);
        return personalDetail;
    }

    public PersonalDetail update(Long id,PersonalDetail personalDetail){
        PersonalDetail personalDetail2 = getbyid(id);
        personalDetail2.setFirs_name(personalDetail.getFirs_name());
        personalDetail2.setSecond_name(personalDetail.getSecond_name());
        personalDetail2.setLast_name(personalDetail.getLast_name());
        personalDetail2.setLocation(personalDetail.getLocation());
        personalDetail2.setCity(personalDetail.getCity());
        personalDetail2.setGender(personalDetail.getGender());
        personalDetail2.setBiography(personalDetail.getBiography());
        personalDetail2.setPhone(personalDetail.getPhone());
        personalDetail2.setEmail(personalDetail.getEmail());
        personalDetail2.setPass(personalDetail.getPass());
        PersonalDetail personalDetail3 = personalDetailRepo.save(personalDetail2);
        return personalDetail3;
    

       
    }
    public List<PersonalDetail> getbyforeignP(Long id){
        return personalDetailRepo.findByforeign(id);
    }

    public List<Education> getbyforeignE(Long id){
        
        return educationRepo.findByforeign(id);
    }

    public List<Experiance> getbyforeignEx(Long id){
        
        return experianceRepo.findByforeign(id);
    }

    public List<Skill> getbyforeignSkill(Long id){
        
        return skillRepo.findByforeign(id);
    }

public List<PersonalDetail> getbyemail(String email,String pass){
        return personalDetailRepo.findByEmail(email,pass);
}
 
}
