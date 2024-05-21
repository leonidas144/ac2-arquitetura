package com.example.xyz.services;

import java.util.List;
import java.util.Optional;

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

    public Agenda findById(Integer id){
        Optional<Agenda> obj = repository.findById(id);
        return obj.get();
    }

    public Agenda insert(Agenda obj){
        return repository.save(obj);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Agenda update(Integer id, Agenda obj){
        Agenda entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Agenda entity, Agenda obj) {
        entity.setNomeCurso(obj.getNomeCurso());
        entity.setProfessor(obj.getProfessor());
        entity.setCidade(obj.getCidade());
        entity.setEstado(obj.getEstado());
        entity.setDataInicio(obj.getDataInicio());
        entity.setDataFim(obj.getDataFim());
        entity.setDiario(obj.getDiario());
    }

    

    




    
}
