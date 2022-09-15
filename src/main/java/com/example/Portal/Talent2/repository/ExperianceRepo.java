package com.example.Portal.Talent2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Portal.Talent2.modal.Experiance;

public interface ExperianceRepo extends JpaRepository<Experiance,Long> {
    @Query(value="SELECT * FROM experience WHERE personal_detail_personal_id = ?1 ",nativeQuery = true)
    List<Experiance> findByforeign(Long id);
}
