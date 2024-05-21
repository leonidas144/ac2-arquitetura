package com.example.xyz.controllers;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.xyz.entities.Professor;
import com.example.xyz.services.ProfessorService;

@RestController
@RequestMapping(value = "/professor")
public class ProfessorController {
    
    @Autowired
    private ProfessorService service;

    @GetMapping
    public ResponseEntity<List<Professor>> findAll(){
        List<Professor> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{cpf}")
    public ResponseEntity <Professor> findById(@PathVariable String cpf){
        Professor obj = service.findById(cpf);
            return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity <Professor> insert(@RequestBody Professor obj){
            obj = service.insert(obj);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCpf()).toUri();
            return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity <Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

   @PutMapping(value = "/{id}")
    public ResponseEntity<Professor> update(@PathVariable String id, @RequestBody Professor obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
        }
        

}
