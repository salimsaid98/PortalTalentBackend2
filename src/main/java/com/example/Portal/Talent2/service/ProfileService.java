package com.example.Portal.Talent2.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Portal.Talent2.dto.ProfileRequestDTO;
import com.example.Portal.Talent2.dto.ProfileRespondDTO;
import com.example.Portal.Talent2.exception.Datanotfound;
import com.example.Portal.Talent2.modal.Education;
import com.example.Portal.Talent2.modal.Experiance;
import com.example.Portal.Talent2.modal.PersonalDetail;
import com.example.Portal.Talent2.modal.Profle;
import com.example.Portal.Talent2.modal.Skill;
import com.example.Portal.Talent2.modal.User;
import com.example.Portal.Talent2.repository.ProfileRepo;

import lombok.Data;
@Data
@Service
public class ProfileService {

    @Autowired
    private ProfileRepo profileRepo;

    @Autowired
    private ModelMapper modelMapper;


        public Profle save(ProfileRequestDTO profileRequestDTO){

            PersonalDetail personalDetail = new PersonalDetail();
            Education education = new Education();
            Experiance experiance = new Experiance();
            Skill skill = new Skill();
            User user = new User();
            personalDetail.setPersonal_id(profileRequestDTO.getPersonal_id());
            education.setEducation_id(profileRequestDTO.getEducation_id());
            skill.setSlill_id(profileRequestDTO.getEducation_id());
            experiance.setExperience_id(profileRequestDTO.getExperience_id());
            user.setUser_id(profileRequestDTO.getUser_id());

            Profle profle= modelMapper.map(profileRequestDTO,Profle.class);

            profle.setPersonalDetail(personalDetail);
            profle.setEducation(education);
            profle.setExperiance(experiance);
            profle.setSkill(skill);
            profle.setUser(user);
            Profle profle2 = profileRepo.save(profle);
            return profle2;
            
        }

        public List<ProfileRespondDTO> getall(){
            List<ProfileRespondDTO> list = new ArrayList<>();
             ProfileRespondDTO profileRespondDTO = new ProfileRespondDTO();

             for(Profle profle : profileRepo.findAll()){
                profileRespondDTO = modelMapper.map(profle , ProfileRespondDTO.class);
                // personal info set and get
                profileRespondDTO.setFirs_name(profle.getPersonalDetail().getFirs_name());
                profileRespondDTO.setSecond_name(profle.getPersonalDetail().getSecond_name());
                profileRespondDTO.setLast_name(profle.getPersonalDetail().getLast_name());
                profileRespondDTO.setLocation(profle.getPersonalDetail().getLocation());
                profileRespondDTO.setCity(profle.getPersonalDetail().getCity());
                profileRespondDTO.setGender(profle.getPersonalDetail().getGender());
                profileRespondDTO.setPhone(profle.getPersonalDetail().getPhone());
                profileRespondDTO.setBiography(profle.getPersonalDetail().getBiography());

                // education info set and get
                profileRespondDTO.setCollage_name(profle.getEducation().getCollage_name());
                profileRespondDTO.setEducation_year_start(profle.getEducation().getEducation_year_start());
                profileRespondDTO.setEducation_year_end(profle.getEducation().getEducation_year_end());
                profileRespondDTO.setLevel(profle.getEducation().getLevel());
                profileRespondDTO.setStudy(profle.getEducation().getStudy());

                // skill info set and get
                profileRespondDTO.setSkill_name(profle.getSkill().getSkill_name());

                //experience info set and get
                profileRespondDTO.setCompany_name(profle.getExperiance().getCompany_name());
                profileRespondDTO.setLocations(profle.getExperiance().getLocations());
                profileRespondDTO.setStartyear(profle.getExperiance().getStartyear());
                profileRespondDTO.setEndyear(profle.getExperiance().getEndyear());

                // User info set and get
                profileRespondDTO.setUser_name(profle.getUser().getUser_name());
                profileRespondDTO.setEmail(profle.getUser().getEmail());

                list.add(profileRespondDTO);

             }
             return list;
        }


        public Profle getbyid(Long id){
            Profle profle = profileRepo.findById(id).orElseThrow(()->new Datanotfound("invalid id"));
            return profle;
           }
       
           public Profle delete(Long id){
            Profle profle= getbyid(id);
            profileRepo.delete(profle);
               return profle;
           }
            

        }


