package com.ete.sunny.services;

import com.ete.sunny.model.aluno.Aluno;

import com.ete.sunny.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;


@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno createAluno(Aluno comum){
        return alunoRepository.save(comum);
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

    public Page<Aluno> findAll(Pageable page){
        return alunoRepository.findAll(page);
    }
}
