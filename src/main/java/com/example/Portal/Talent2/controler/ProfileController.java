package com.example.Portal.Talent2.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Portal.Talent2.dto.ProfileRequestDTO;
import com.example.Portal.Talent2.dto.ProfileRespondDTO;
import com.example.Portal.Talent2.modal.Profle;
import com.example.Portal.Talent2.service.ProfileService;

@RestController
@RequestMapping("Profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;
@PostMapping("/")
    public ResponseEntity<?> save(ProfileRequestDTO profileRequestDTO){
         profileService.save(profileRequestDTO);
         return ResponseEntity.ok().body(profileRequestDTO);
    }
    
@GetMapping("/")
    public ResponseEntity<?> getall(){
        List<ProfileRespondDTO> list = new ArrayList<>();
        for(ProfileRespondDTO profileRespondDTO:profileService.getall()){
            list.add(profileRespondDTO);
        }
        return ResponseEntity.ok().body(list);
        
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getbyid(@PathVariable Long id){
        Profle profle = profileService.getbyid(id);
        return ResponseEntity.ok().body(profle);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Profle profle = profileService.delete(id);
        return ResponseEntity.ok().body(profle);
    }


}
