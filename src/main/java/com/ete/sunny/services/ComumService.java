package com.ete.sunny.services;

import com.ete.sunny.model.aluno.Aluno;

import com.ete.sunny.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComumService {

    @Autowired
    private AlunoRepository alunoRepository;

    public void create(Aluno comum){
        alunoRepository.save(comum);
    }

    public List<Aluno> findAll(){
        return alunoRepository.findAll();
    }


    public void deleteAluno(Long id){
        Optional<Aluno> comum = alunoRepository.findById(id);
        comum.ifPresent(userComum -> alunoRepository.delete(userComum));
    }
    public Aluno buscarAlunoId(Long id){
        Optional<Aluno> usuario = alunoRepository.findById(id);
        return usuario.orElse(null);
    }
    public Aluno atualizarAluno(Long id, Aluno alunoaux){
        var aluno = alunoRepository.findById(id);
        aluno.get().setCPF(alunoaux.getCPF());
        aluno.get().setNome(alunoaux.getNome());
        aluno.get().setEmail(alunoaux.getEmail());
        aluno.get().setPassword(alunoaux.getPassword());
        aluno.get().setPontuacao(alunoaux.getPontuacao());
        return alunoRepository.save(aluno.get());


    }

    public  boolean existeAluno(Long id){
        return !alunoRepository.existsById(id);
    }
}
