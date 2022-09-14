package com.example.Portal.Talent2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Portal.Talent2.exception.Datanotfound;
import com.example.Portal.Talent2.modal.Experiance;
import com.example.Portal.Talent2.repository.ExperianceRepo;

import lombok.Data;
@Data
@Service
public class ExperianceService {
    @Autowired
    private ExperianceRepo experianceRepo;

    public Experiance save(Experiance experiance){
        Experiance Experiance2 = experianceRepo.save(experiance);
        return Experiance2;
    }

    public List<Experiance> getall(){
        List<Experiance>list = new ArrayList<>();
        for(Experiance experiance:experianceRepo.findAll()){
            list.add(experiance);
        }
        return list;
    }

    public Experiance getbyid(Long id){
     Experiance Experiance = experianceRepo.findById(id).orElseThrow(()->new Datanotfound("invalid id"));
     return Experiance;
    }

    public Experiance delete(Long id){
        Experiance experiance = getbyid(id);
       experianceRepo.delete(experiance);
        return experiance;
    }

    public Experiance update(Long id, Experiance experiance){
        Experiance experiance2 = getbyid(id);
        experiance2.setCompany_name(experiance.getCompany_name());
        experiance2.setLocations(experiance.getLocations());
        experiance2.setStartyear(experiance.getStartyear());
        experiance2.setEndyear(experiance.getEndyear());
        Experiance experiance3= experianceRepo.save(experiance2);
        return experiance3;

    }

}
