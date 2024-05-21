package com.example.xyz.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.xyz.entities.Agenda;
import com.example.xyz.entities.Curso;
import com.example.xyz.entities.Professor;
import com.example.xyz.repositories.AgendaRepository;
import com.example.xyz.repositories.CursoRepository;
import com.example.xyz.repositories.ProfessorRepository;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Curso> findAll(){
        return cursoRepository.findAll();
    }

    public Curso findById(Integer id){
        Optional<Curso> obj = cursoRepository.findById(id);
        return obj.get();
    }

    public Curso insert(Professor professor, Curso curso, Agenda agenda){
        if (!verificarEspecialidadeProfessor(professor, curso)) {
            throw new IllegalArgumentException("O professor não tem a especialidade necessária para este curso.");
        }
        
        if (verificarConflitoHorarios(professor, agenda.getDataInicio(), agenda.getDataFim())) {
            throw new IllegalArgumentException("Conflito de horários com outros cursos do professor.");
        }
        

        
        return cursoRepository.save(curso);
        
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


    public boolean cadastrarCurso(Curso curso, Professor professor, Agenda agenda) {
        
        // Realizar validação de especialidade do professor
        if (!verificarEspecialidadeProfessor(professor, curso)) {
            throw new IllegalArgumentException("O professor não tem a especialidade necessária para este curso.");
        }
        
        // Verificar conflito de horários
        if (verificarConflitoHorarios(professor, agenda.getDataInicio(), agenda.getDataFim())) {
            throw new IllegalArgumentException("Conflito de horários com outros cursos do professor.");
        }

        cursoRepository.save(curso);
    
        // Atualizar a agenda com o novo curso
        agendaRepository.save(agenda);

        return true;
    }

     private boolean verificarEspecialidadeProfessor(Professor professor, Curso curso) {
        // Implementar lógica para verificar se o professor tem a especialidade necessária
        boolean valida = (professor.getEspecialidade().equalsIgnoreCase(curso.getDescricao()));

        return valida;
    }

    private boolean verificarConflitoHorarios(Professor professor, LocalDateTime dataInicio, LocalDateTime dataFim) {
        // Buscar agendas do professor que se sobrepõem ao horário fornecido
        List<Agenda> agendasConflitantes = agendaRepository.findByProfessorAndHorario(professor, dataInicio, dataFim);
        
        
        // List<Agenda> agendas = agendaRepository.findAll();
        // if(!agendas.contains(agenda) || (agendas == null)) {
        //     return false;
        return !agendasConflitantes.isEmpty();
        }
        
    }

        // Verificar se há alguma agenda com o mesmo horário
    
