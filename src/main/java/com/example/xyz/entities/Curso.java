package com.example.xyz.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private int cargaHoraria;
    private String objetivo;
    private String ementa;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinTable(
        name = "professor_curso",
        joinColumns = @JoinColumn(name = "curso_id"),
        inverseJoinColumns = @JoinColumn(name = "professor_cpf")
    )
    private Professor professores;

    @JsonBackReference
    @OneToMany(mappedBy = "curso", cascade = CascadeType.REMOVE)
    private List<Agenda> agendas;

    
    public Curso() {
    }

    public Curso(Integer id, String descricao, int cargaHoraria, String objetivo, String ementa) {
        this.id = id;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.objetivo = objetivo;
        this.ementa = ementa;
        
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public int getCargaHoraria() {
        return cargaHoraria;
    }
    
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    
    public String getObjetivo() {
        return objetivo;
    }
    
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
    
    public String getEmenta() {
        return ementa;
    }
    
    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public Professor getProfessores() {
        return professores;
    }

    public void setProfessores(Professor professores) {
        this.professores = professores;
    }

    public List<Agenda> getAgendas() {
        return agendas;
    }

    public void setAgendas(List<Agenda> agendas) {
        this.agendas = agendas;
    }
    
}
