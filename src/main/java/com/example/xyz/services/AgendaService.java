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
public class AgendaService {

    @Autowired
    private AgendaRepository repository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Agenda> findAll(){
        return repository.findAll();
    }

    public Agenda findById(Integer id){
        Optional<Agenda> obj = repository.findById(id);
        return obj.get();
    }

    public List<Agenda> findAgendaByProfessorCpf(String cpf) {
        Professor professor = professorRepository.findById(cpf)
                .orElseThrow(() -> new IllegalArgumentException("Professor não encontrado com CPF: " + cpf));
        return repository.findByProfessor(professor);
    }

    public List<Professor> findProfessoresByCursoEspecialidade(Integer cursoId) {
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado com ID: " + cursoId));
        return professorRepository.findByEspecialidade(curso.getDescricao());
    }

    public Agenda insert(Agenda obj){
        return repository.save(obj);
    }

    public Agenda cadastrarAgenda(Agenda agenda){
        String professorCpf = agenda.getProfessor().getCpf();
        Integer cursoDesc = agenda.getCursos().getId();

        // Curso curso = agenda.getCursos();

        Optional<Professor> optionalProfessor = professorRepository.findById(professorCpf);
        Professor professorEncontrado = optionalProfessor.orElseThrow(() -> new IllegalArgumentException("Professor não encontrado com CPF: " + professorCpf));
        
        Optional<Curso> optionalCurso = cursoRepository.findById(cursoDesc);
        Curso cursoEncontrado = optionalCurso.orElseThrow(() -> new IllegalArgumentException("Curso não encontrado com o id: " + cursoDesc));
        
        // Validar especialidade do professor
        if (!verificarEspecialidadeProfessor(professorEncontrado,cursoEncontrado)) {
            throw new IllegalArgumentException("O professor não tem a especialidade necessária para este curso.");
        }

        // Validar conflitos de horários
        if (verificarConflitoHorarios(professorEncontrado, agenda.getDataInicio(), agenda.getDataFim())) {
            throw new IllegalArgumentException("Conflito de horários com outros cursos do professor.");
        }

        // Associar o curso à agenda e salvar
        agenda.setProfessor(professorEncontrado);
        agenda.setCurso(cursoEncontrado);
        return repository.save(agenda);
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
        entity.setCurso(obj.getCursos());
        entity.setProfessor(obj.getProfessor());
        entity.setCidade(obj.getCidade());
        entity.setEstado(obj.getEstado());
        entity.setDataInicio(obj.getDataInicio());
        entity.setDataFim(obj.getDataFim());
        entity.setDiario(obj.getDiario());
    }

    public Agenda atualizarResumo(Integer id, String diario) {
        Agenda agenda = findById(id);
        agenda.setDiario(diario);
        return repository.save(agenda);
    }


    private boolean verificarEspecialidadeProfessor(Professor professor, Curso curso) {
        return professor.getEspecialidade().equalsIgnoreCase(curso.getDescricao());
    }

    private boolean verificarConflitoHorarios(Professor professor, LocalDateTime dataInicio, LocalDateTime dataFim) {
        List<Agenda> agendasConflitantes = repository.findByProfessorAndHorario(professor, dataInicio, dataFim);
        return !agendasConflitantes.isEmpty();
    }
    

    




    
}
