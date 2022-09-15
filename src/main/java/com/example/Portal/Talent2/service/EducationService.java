package com.example.Portal.Talent2.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Portal.Talent2.exception.Datanotfound;
import com.example.Portal.Talent2.modal.Education;
import com.example.Portal.Talent2.modal.PersonalDetail;
import com.example.Portal.Talent2.repository.EducationRepo;

import lombok.Data;
@Data
@Service
public class EducationService {
    @Autowired
    private EducationRepo educationRepo;

    public Education save(Education education){
        PersonalDetail personalDetail = new PersonalDetail();
        personalDetail.setPersonal_id(education.getPersonalDetail().getPersonal_id());
        Education education2 = educationRepo.save(education);
        education2.setPersonalDetail(personalDetail);
        return education2;
    }

    public List<Education> getall(){
        List<Education>list = new ArrayList<>();
        for(Education education:educationRepo.findAll()){
            list.add(education);
        }
        return list;
    }

    public Education getbyid(Long id){
     Education education = educationRepo.findById(id).orElseThrow(()->new Datanotfound("invalid id"));
     return education;
    }

    public Education delete(Long id){
        Education education = getbyid(id);
       educationRepo.delete(education);
        return education;
    }

    public Education update(Long id, Education education){
        Education education2 = getbyid(id);
        education2.setCollage_name(education.getCollage_name());
        education2.setStudy(education.getStudy());
        education.setLevel(education.getLevel());
        education2.setEducation_year_start(education.getEducation_year_start());
        education2.setEducation_year_end(education.getEducation_year_end());
            Education education3= educationRepo.save(education2);
        return education3;

    }
   public List<Education> getbyforeign(Long id){
    return educationRepo.findByforeign(id);
   }
}
