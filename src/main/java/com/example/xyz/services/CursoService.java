package com.example.xyz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.xyz.entities.Curso;
import com.example.xyz.repositories.CursoRepository;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;

    public List<Curso> findAll(){
        return repository.findAll();
    }
    
}
