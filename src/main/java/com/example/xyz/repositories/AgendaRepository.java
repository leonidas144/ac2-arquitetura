package com.example.xyz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.xyz.entities.Agenda;

public interface AgendaRepository extends JpaRepository <Agenda, Integer> {
    
}
