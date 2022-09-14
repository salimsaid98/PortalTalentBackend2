package com.example.Portal.Talent2.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Portal.Talent2.modal.PersonalDetail;

public interface PersonalDetailRepo extends JpaRepository<PersonalDetail,Long>{
    
}
