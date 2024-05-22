package com.example.xyz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.xyz.entities.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, String> {

    
}
