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

import com.example.Portal.Talent2.modal.User;
import com.example.Portal.Talent2.service.UserService;


import lombok.Data;
@Data
@RestController
@RequestMapping("User")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody User user){
        User user2 = userService.save(user);
        return ResponseEntity.ok().body(user2);
    }
    @GetMapping("/")
    public ResponseEntity<?> getall(){
        List<User> list = new ArrayList<>();
        for(User user : userService.getall()){
            list.add(user);
        }
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getbyid(@PathVariable Long id){
        User User = userService.getbyid(id);
        return ResponseEntity.ok().body(User);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        User User = userService.delete(id);
        return ResponseEntity.ok().body(User);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id ,@RequestBody User User){
            User User2 = userService.update(id, User);
            return ResponseEntity.ok().body(User2);
    }
}
