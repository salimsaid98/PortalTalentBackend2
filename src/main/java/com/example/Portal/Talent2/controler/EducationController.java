package com.example.Portal.Talent2.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Portal.Talent2.modal.Education;
import com.example.Portal.Talent2.service.EducationService;

import lombok.Data;
@Data
@RestController
@RequestMapping("Education")
public class EducationController {
    @Autowired
    private EducationService educationService;
    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Education education){
        Education education2 = educationService.save(education);
        return ResponseEntity.ok().body(education2);

    }
    @GetMapping("/")
    public ResponseEntity<?> getall(){
        List<Education> list = new ArrayList<>();
        for(Education education: educationService.getall()){
            list.add(education);
        }
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getbyid(@PathVariable Long id){
        Education education = educationService.getbyid(id);
        return ResponseEntity.ok().body(education);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Education education = educationService.delete(id);
        return ResponseEntity.ok().body(education);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id ,@RequestBody Education education){
            Education education2 = educationService.update(id, education);
            return ResponseEntity.ok().body(education2);
    }
}
