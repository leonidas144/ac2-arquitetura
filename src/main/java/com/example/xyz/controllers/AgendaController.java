package com.example.xyz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.xyz.entities.Agenda;
import com.example.xyz.entities.Professor;
import com.example.xyz.services.AgendaService;

@RestController
@RequestMapping(value = "/agenda")
public class AgendaController {

    @Autowired
    private AgendaService service;

    @GetMapping
   public ResponseEntity<List<Agenda>> findAll(){
        List<Agenda> list = service.findAll();
        return ResponseEntity.ok().body(list);
   }

   @GetMapping(value = "/{id}")
   public ResponseEntity <Agenda> findById(@PathVariable Integer id){
    Agenda obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
   }

   @GetMapping("/professor/{cpf}")
    public ResponseEntity<List<Agenda>> getAgendaByProfessorCpf(@PathVariable String cpf) {
        List<Agenda> agendas = service.findAgendaByProfessorCpf(cpf);
        return ResponseEntity.ok().body(agendas);
    }

   @PostMapping("/cadastrar")
   public Agenda cadastrarAgenda(@RequestBody Agenda agenda, Professor professor){
    return service.cadastrarAgenda(agenda);
   }

   @PostMapping
   public ResponseEntity <Agenda> insert(@RequestBody Agenda obj){
        Agenda newAgenda = service.cadastrarAgenda(obj);   
        return ResponseEntity.ok().body(newAgenda);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity <Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

   @PutMapping(value = "/{id}")
    public ResponseEntity<Agenda> update(@PathVariable Integer id, @RequestBody Agenda obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    
    
    
}
