package com.example.Portal.Talent2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Portal.Talent2.exception.Datanotfound;
import com.example.Portal.Talent2.modal.PersonalDetail;
import com.example.Portal.Talent2.repository.PersonalDetailRepo;

import lombok.Data;
@Data
@Service
public class PersonalDetailService {
    @Autowired
    private PersonalDetailRepo personalDetailRepo;


    public PersonalDetail save(PersonalDetail personalDetail){
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
        PersonalDetail personalDetail3 = personalDetailRepo.save(personalDetail2);
        return personalDetail3;
    

       
    }
}
