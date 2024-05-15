package com.example.xyz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.xyz.entities.Professor;


public interface ProfessorRepository extends JpaRepository<Professor, String> {
    
}
