package com.example.Portal.Talent2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Portal.Talent2.exception.Datanotfound;
import com.example.Portal.Talent2.modal.PersonalDetail;
import com.example.Portal.Talent2.modal.Skill;
import com.example.Portal.Talent2.repository.SkillRepo;

import lombok.Data;
@Data
@Service
public class SkillService {
    @Autowired
    private SkillRepo skillRepo;

    public Skill save(Skill skill){
        PersonalDetail personalDetail = new PersonalDetail();
        personalDetail.setPersonal_id(skill.getPersonalDetail().getPersonal_id());
        Skill skill2 = skillRepo.save(skill);
        return skill2;
    }

    public List<Skill> getall(){
        List<Skill>list = new ArrayList<>();
        for(Skill skill:skillRepo.findAll()){
            list.add(skill);
        }
        return list;
    }

    public Skill getbyid(Long id){
     Skill skill = skillRepo.findById(id).orElseThrow(()->new Datanotfound("invalid id"));
     return skill;
    }

    public Skill delete(Long id){
        Skill skill = getbyid(id);
       skillRepo.delete(skill);
        return skill;
    }

    public Skill update(Long id, Skill skill){
        Skill skill2 = getbyid(id);
        skill2.setSkill_name(skill.getSkill_name());
        Skill skill3= skillRepo.save(skill2);
        return skill3;

    }
}
