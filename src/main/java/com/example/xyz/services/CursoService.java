package com.example.xyz.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.xyz.entities.Curso;
import com.example.xyz.repositories.CursoRepository;


@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> findAll(){
        return cursoRepository.findAll();
    }

    public Curso findById(Integer id){
        Optional<Curso> obj = cursoRepository.findById(id);
        return obj.get();
    }

    public List<Curso> getCursosByProfessorCpf(String cpf) {
        return cursoRepository.findCursosByProfessorCpf(cpf);
    }

    public Curso insert(Curso obj){
        return cursoRepository.save(obj);       
    }   
    
    public void delete(Integer id) {
        cursoRepository.deleteById(id);
    }

    public Curso update(Integer id, Curso obj){
        Curso entity = cursoRepository.getReferenceById(id);
        updateData(entity, obj);
        return cursoRepository.save(entity);
    }

    private void updateData(Curso entity, Curso obj) {
        entity.setDescricao(obj.getDescricao());
        entity.setEmenta(obj.getEmenta());
        entity.setObjetivo(obj.getObjetivo());
        entity.setCargaHoraria(obj.getCargaHoraria());
        entity.setProfessores(obj.getProfessores());
    } 
        
}
    
