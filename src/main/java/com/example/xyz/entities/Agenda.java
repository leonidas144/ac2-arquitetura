package com.example.xyz.entities;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;

@Entity
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeCurso;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String cidade;
    private String estado;
    private String cep;
    private String diario;


    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinTable(
        name = "agenda_professor",
        joinColumns = @JoinColumn(name = "agenda_id"),
        inverseJoinColumns = @JoinColumn(name = "professor_cpf"))
    private Professor professor;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinTable(
        name = "agenda_curso",
        joinColumns = @JoinColumn(name = "agenda_id"),
        inverseJoinColumns = @JoinColumn(name = "curso_id"))
    private Curso curso;

    public Agenda() {
    }

    public Agenda(Integer id, String nomeCurso, LocalDateTime dataInicio, LocalDateTime dataFim, String cidade,
            String estado, String cep, String diario, Professor professor, Curso curso) {
        this.id = id;
        this.nomeCurso = nomeCurso;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.diario = diario;
        this.professor = professor;
        this.curso = curso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getDiario() {
        return diario;
    }

    public void setDiario(String diario) {
        this.diario = diario;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Curso getCursos() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
}
