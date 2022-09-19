package com.example.Portal.Talent2.controler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Portal.Talent2.modal.PersonalDetail;
import com.example.Portal.Talent2.repository.PersonalDetailRepo;
import com.example.Portal.Talent2.service.PersonalDetailService;

import lombok.Data;



@Data
@RestController
@RequestMapping("/pesonalDetail")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonalDetailController {
    @Autowired
    private PersonalDetailService personalDetailService;
    @Autowired
    private PersonalDetailRepo personalDetailRepo;
    @PostMapping
    public ResponseEntity<?> save(@RequestBody PersonalDetail personalDetail){
        PersonalDetail personalDetail2 = personalDetailService.save(personalDetail);
        return ResponseEntity.ok().body(personalDetail2);
    }
    @GetMapping
    public ResponseEntity<?> getall(){
        List<PersonalDetail> list = new ArrayList<>();
        for(PersonalDetail personalDetail : personalDetailService.getall()){
            list.add(personalDetail);
        }
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getbyid(@PathVariable Long id){
        PersonalDetail personalDetail = personalDetailService.getbyid(id);
        return ResponseEntity.ok().body(personalDetail);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        PersonalDetail personalDetail = personalDetailService.delete(id);
        return ResponseEntity.ok().body(personalDetail);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id ,@RequestBody PersonalDetail personalDetail){
            PersonalDetail personalDetail2 = personalDetailService.update(id, personalDetail);
            return ResponseEntity.ok().body(personalDetail2);
    }
    @GetMapping("all_info/{id}")
    public Map readAllData(@PathVariable Long id) {  
        Map<String, Object> list = new HashMap();
        list.put("Personal", personalDetailService.getbyforeignP(id));
        list.put("Education", personalDetailService.getbyforeignE(id));
        list.put("Experience", personalDetailService.getbyforeignEx(id));
        list.put("Skills", personalDetailService.getbyforeignSkill(id));
        return list;
    }
 @PostMapping("/login")
public ResponseEntity<?> postlogin(@RequestBody PersonalDetail personalDetail){
    System.out.println(personalDetail);
    PersonalDetail personalDetail2 =  personalDetailRepo.findByEmail(personalDetail.getEmail());
    if(personalDetail2.getPass().equals(personalDetail.getPass()))
        return ResponseEntity.ok(personalDetail2);
        return (ResponseEntity<?>) ResponseEntity.internalServerError();
}
}
