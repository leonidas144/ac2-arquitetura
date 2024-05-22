package com.example.xyz.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.xyz.entities.Curso;


public interface CursoRepository extends JpaRepository <Curso, Integer> {

     @Query("SELECT c FROM Curso c WHERE c.professores.cpf = :cpf")
    List<Curso> findCursosByProfessorCpf(@Param("cpf") String cpf);

    Optional<Curso> findById(Integer id);
    
}
