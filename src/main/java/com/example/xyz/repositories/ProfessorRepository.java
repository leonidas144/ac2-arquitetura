package com.example.xyz.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.xyz.entities.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, String> {
    @Query("SELECT p FROM Professor p WHERE p.especialidade = :especialidade")
    List<Professor> findByEspecialidade(@Param("especialidade") String especialidade);

    
}
