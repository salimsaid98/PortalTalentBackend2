package com.example.Portal.Talent2.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Portal.Talent2.modal.PersonalDetail;

public interface PersonalDetailRepo extends JpaRepository<PersonalDetail,Long>{


    @Query(value="SELECT * FROM personal_detail WHERE personal_id = ?1 ",nativeQuery = true)
    List<PersonalDetail> findByforeign(Long id);


    @Query(value="select * from personal_detail where email = ?1 ",nativeQuery = true)
    PersonalDetail findByEmail(String email);

   
}
