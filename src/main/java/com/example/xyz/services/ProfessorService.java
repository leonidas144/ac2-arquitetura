package com.example.xyz.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.xyz.entities.Agenda;
import com.example.xyz.entities.Curso;
import com.example.xyz.entities.Professor;
import com.example.xyz.repositories.ProfessorRepository;

@Service
public class ProfessorService {
    
    @Autowired
    private ProfessorRepository repository;

    public List<Professor> findAll(){
        return repository.findAll();
    }

    public Professor findById(String cpf){
        Optional<Professor> obj = repository.findById(cpf);
        return obj.get();
    }

    public Professor insert(Professor obj){
        return repository.save(obj);
    }

    public void delete(String cpf) {
        repository.deleteById(cpf);
    }

    public Professor update(String cpf, Professor obj){
        Professor entity = repository.getReferenceById(cpf);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Professor entity, Professor obj) {
        entity.setNome(obj.getNome());
        entity.setEndereco(obj.getEndereco());
        entity.setEspecialidade(obj.getEspecialidade());
        entity.setCelular(obj.getCelular());
        entity.setCursos(obj.getCursos());
        
    }

}
