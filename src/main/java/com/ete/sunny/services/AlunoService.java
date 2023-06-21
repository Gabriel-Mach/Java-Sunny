package com.ete.sunny.services;

import com.ete.sunny.model.aluno.Aluno;

import com.ete.sunny.model.aluno.DadosAlunoRecord;
import com.ete.sunny.repository.AlunoRepository;
import com.ete.sunny.repository.ResponsavelRepository;
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

    @Autowired
    private ResponsavelRepository responsavelRepository;


    public Aluno createAluno(DadosAlunoRecord aluno){
        var respons = responsavelRepository.findById(aluno.idResponsavel());
        var alun = aluno.toAluno();
        if(respons.isEmpty()){
            throw new RuntimeException("Responsavel nao exite!");
        }else {
            alun.setResponsavel(respons.get());
            return alunoRepository.save(alun);
        }
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
