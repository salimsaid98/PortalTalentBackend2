package com.example.Portal.Talent2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Portal.Talent2.modal.Skill;

public interface SkillRepo extends JpaRepository<Skill,Long>{
    @Query(value="SELECT * FROM skill WHERE personal_detail_personal_id = ?1 ",nativeQuery = true)
    List<Skill> findByforeign(Long id);
}
