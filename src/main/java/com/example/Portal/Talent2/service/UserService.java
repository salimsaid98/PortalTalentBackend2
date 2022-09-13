package com.example.Portal.Talent2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Portal.Talent2.exception.Datanotfound;
import com.example.Portal.Talent2.modal.User;
import com.example.Portal.Talent2.repository.UserRepo;

import lombok.Data;
@Data
@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User save(User User){
        User User2 = userRepo.save(User);
        return User2;
    }

    public List<User> getall(){
        List<User>list = new ArrayList<>();
        for(User User:userRepo.findAll()){
            list.add(User);
        }
        return list;
    }

    public User getbyid(Long id){
     User User = userRepo.findById(id).orElseThrow(()->new Datanotfound("invalid id"));
     return User;
    }

    public User delete(Long id){
        User User = getbyid(id);
       userRepo.delete(User);
        return User;
    }

    public User update(Long id,User user){
        User user2 = getbyid(id);
        user2.setUser_name(user.getUser_name());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        User user3 = userRepo.save(user2);
        return user3;
    

       
    }
}
