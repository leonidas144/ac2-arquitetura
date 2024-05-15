package com.example.xyz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.xyz.entities.Curso;

public interface CursoRepository extends JpaRepository <Curso, Integer> {
    
}
