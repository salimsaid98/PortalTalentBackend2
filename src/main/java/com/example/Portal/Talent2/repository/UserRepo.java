package com.example.Portal.Talent2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Portal.Talent2.modal.User;

public interface UserRepo extends JpaRepository<User,Long> {
    
}
