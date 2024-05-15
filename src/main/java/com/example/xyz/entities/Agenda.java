package com.example.xyz.entities;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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

    private List<Professor> professores = new ArrayList<>();

    private List<Curso> cursos = new ArrayList<>();

    public Agenda() {
    }

    public Agenda(Integer id, String nomeCurso, LocalDateTime dataInicio, LocalDateTime dataFim, String cidade,
            String estado, String cep, String diario, List<Professor> professores, List<Curso> cursos) {
        this.id = id;
        this.nomeCurso = nomeCurso;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.diario = diario;
        this.professores = professores;
        this.cursos = cursos;
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

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
}
