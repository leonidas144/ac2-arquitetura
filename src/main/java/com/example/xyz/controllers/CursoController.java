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

import com.example.xyz.entities.Curso;
import com.example.xyz.services.CursoService;

@RestController
@RequestMapping(value = "/curso")
public class CursoController {

   @Autowired
   private CursoService service;

   @GetMapping
   public ResponseEntity<List<Curso>> findAll(){
        List<Curso> list = service.findAll();
        return ResponseEntity.ok().body(list);
   }

   @GetMapping(value = "/{id}")
   public ResponseEntity <Curso> findById(@PathVariable Integer id){
        Curso obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
   }

   @GetMapping("/professor/{cpf}")
   public List<Curso> getCursosByProfessor(@PathVariable String cpf) {
       return service.getCursosByProfessorCpf(cpf);
   }

   @PostMapping
    public ResponseEntity<Curso> insert(@RequestBody Curso obj) {
          obj = service.insert(obj);
          URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
          return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity <Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

   @PutMapping(value = "/{id}")
    public ResponseEntity<Curso> update(@PathVariable Integer id, @RequestBody Curso obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
        }
    
    
    
}
