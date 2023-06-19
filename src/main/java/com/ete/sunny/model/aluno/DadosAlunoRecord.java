package com.ete.sunny.model.aluno;


import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosAlunoRecord(

        @Id
        Long id,

        @NotNull
        @Size(min = 11, max = 11)
        String cpf,
        @NotNull
        @Size(max = 100)
        String nome,

        @NotNull
        @Email
        @Size(max = 100)
        String email,

        @NotNull
        @Size(min = 8, max = 100)
        String password



) {
    public Aluno toAluno(DadosAlunoRecord alunoRecord){
        return new Aluno( null,cpf(),nome(),email(),password());
            //QUAL O PROBLEMA QUE ESTÁ DANDO AQUI???
    }




}
