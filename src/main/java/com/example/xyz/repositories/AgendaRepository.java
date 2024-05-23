package com.example.xyz.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.xyz.entities.Agenda;
import com.example.xyz.entities.Professor;

@Repository
public interface AgendaRepository extends JpaRepository <Agenda, Integer> {

     List<Agenda> findByProfessor(Professor professor);

     @Query("SELECT a FROM Agenda a WHERE a.professor = :professor AND " +
            "(:dataInicio < a.dataFim AND :dataFim > a.dataInicio)")
     List<Agenda> findByProfessorAndHorario(@Param("professor") Professor professor,
                                            @Param("dataInicio") LocalDateTime dataInicio,
                                            @Param("dataFim") LocalDateTime dataFim);



}

     

    

