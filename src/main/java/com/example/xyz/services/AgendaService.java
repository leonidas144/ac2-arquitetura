package com.example.xyz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.xyz.entities.Agenda;
import com.example.xyz.repositories.AgendaRepository;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository repository;

    public List<Agenda> findAll(){
        return repository.findAll();
    }
    
}
