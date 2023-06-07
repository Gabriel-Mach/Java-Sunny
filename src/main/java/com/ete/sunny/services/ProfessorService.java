package com.ete.sunny.services;

import com.ete.sunny.model.professor.Professor;
import com.ete.sunny.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;
    public Professor criarProf(Professor professor) {
        return professorRepository.save(professor);
    }
    public Professor buscarProfId(Long id){
        Optional<Professor> professor = professorRepository.findById(id);
        return professor.orElse(null);
    }

    public Page<Professor> findAll(Pageable page) {
        return professorRepository.findAll(page);

    }
    public Professor atualizarProfessor (Professor professor){
        return professorRepository.save(professor);
    }
    public void deletarProfessor (Long id){
        professorRepository.deleteById(id);
    }
    public boolean existeProfessor(Long id){
        return !professorRepository.existsById(id);
    }
}
