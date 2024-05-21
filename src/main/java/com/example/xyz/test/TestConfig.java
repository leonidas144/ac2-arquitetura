package com.example.xyz.test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.xyz.entities.Agenda;
import com.example.xyz.entities.Curso;
import com.example.xyz.entities.Professor;
import com.example.xyz.repositories.AgendaRepository;
import com.example.xyz.repositories.CursoRepository;
import com.example.xyz.repositories.ProfessorRepository;
import com.example.xyz.services.AgendaService;
import com.example.xyz.services.CursoService;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
    
    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ProfessorRepository professorRepository;
    
    @Autowired
    CursoService cursoService;
    
    @Autowired
    AgendaService agendaService;


    @Override
    public void run(String... args) throws Exception {


        LocalDateTime dataInicio = LocalDateTime.of(2024, 5, 15, 10, 30, 0);
        LocalDateTime dataFim = LocalDateTime.of(2024, 5, 15, 13, 30, 0);
        LocalDateTime dataInicio2 = LocalDateTime.of(2025, 5, 15, 10, 30, 0);
        LocalDateTime dataFim2 = LocalDateTime.of(2025, 5, 15, 13, 30, 0);


        Professor p1 = new Professor("1234", "Jão", "123", "Rua Cravos", "987654", "ADS");
        Professor p3 = new Professor();

        Curso c1 = new Curso(null, "ADS", 250, "Capacitar alunos", "null",p1);
        Curso c2 = new Curso(null, "ADS2", 250, "Capacitar alunos2", "null", p1);


       
        // Professor p2 = new Professor("2", null, null, null, null, null);

        Agenda a1 = new Agenda(null, "ADS", dataInicio, dataFim, "adf", "adf", "adf", "adf",p1, c1);
        Agenda a2 = new Agenda(null, "ADS", dataInicio2, dataFim2, "adf", "adf", "adf", "adf",p1, c2);

        professorRepository.saveAll(Arrays.asList(p1));
        cursoRepository.saveAll(Arrays.asList(c2));
        agendaRepository.saveAll(Arrays.asList(a2));

        if(cursoService.cadastrarCurso(c1, p1, a1)){
            cursoRepository.save(c1);
            agendaRepository.save(a1);
        }
        
        

        


}
}
