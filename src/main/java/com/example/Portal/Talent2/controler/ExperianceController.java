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

import com.example.Portal.Talent2.modal.Experiance;
import com.example.Portal.Talent2.service.ExperianceService;

import lombok.Data;
@Data
@RestController
@RequestMapping("Experience")
public class ExperianceController {
    
    @Autowired
    private ExperianceService experianceService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Experiance experiance){
        Experiance experiance2 = experianceService.save(experiance);
        return ResponseEntity.ok().body(experiance2);
    }
    @GetMapping
    public ResponseEntity<?> getall(){
        List<Experiance> list = new ArrayList<>();
        for(Experiance Experiance : experianceService.getall()){
            list.add(Experiance);
        }
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getbyid(@PathVariable Long id){
        Experiance Experiance = experianceService.getbyid(id);
        return ResponseEntity.ok().body(Experiance);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Experiance Experiance = experianceService.delete(id);
        return ResponseEntity.ok().body(Experiance);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id ,@RequestBody Experiance Experiance){
            Experiance Experiance2 = experianceService.update(id, Experiance);
            return ResponseEntity.ok().body(Experiance2);
    }

}
