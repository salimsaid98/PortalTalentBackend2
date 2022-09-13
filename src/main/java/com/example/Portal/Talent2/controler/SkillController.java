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

import com.example.Portal.Talent2.modal.Skill;
import com.example.Portal.Talent2.service.SkillService;

import lombok.Data;
@Data
@RestController
@RequestMapping("Skill")
public class SkillController {
    @Autowired
    private SkillService skillService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Skill skill){
        Skill skill2 = skillService.save(skill);
        return ResponseEntity.ok().body(skill2);
    }
    @GetMapping
    public ResponseEntity<?> getall(){
        List<Skill> list = new ArrayList<>();
        for(Skill skill : skillService.getall()){
            list.add(skill);
        }
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getbyid(@PathVariable Long id){
        Skill skill = skillService.getbyid(id);
        return ResponseEntity.ok().body(skill);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Skill skill = skillService.delete(id);
        return ResponseEntity.ok().body(skill);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id ,@RequestBody Skill skill){
            Skill skill2 = skillService.update(id, skill);
            return ResponseEntity.ok().body(skill2);
    }

}
